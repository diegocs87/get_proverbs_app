package com.example.clean_test.data.repository.handler

import android.content.Context
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDataSourceImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetNetworkConnectionVerifierImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetProverbsRemoteDataSourceImplementationQualifier
import com.example.clean_test.data.model.toDomain
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.data.repository.local.LocalDataSource
import com.example.clean_test.data.repository.remote.RemoteRepositoryDataSource
import com.example.clean_test.domain.entities.ProverbsStates
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import javax.inject.Inject

class ProverbsRepositoryHandlerImplementation @Inject constructor(
    @GetLocalProverbsDataSourceImplementationQualifier private val localSource: LocalDataSource,
    @GetProverbsRemoteDataSourceImplementationQualifier private val remoteSource: RemoteRepositoryDataSource,
    @GetNetworkConnectionVerifierImplementationQualifier private val networkConnectionVerifier: NetworkConnectionVerifier
) : ProverbsRepositoryHandler {

    override suspend fun retrieveFromSource(context: Context): ProverbsStates {
        return if (networkConnectionVerifier.verify()) {
            retrieveFromApi(context)
        } else {
            retrieveFromLocal()
        }
    }

    private suspend fun retrieveFromLocal(): ProverbsStates {
        val localProverbs = localSource.getAll()
        return if (localProverbs.isNotEmpty()) {
            val domainProverbs = localProverbs.map { proverbsList -> proverbsList.toDomain() }
            ProverbsStates.OnSuccessRetrieved(domainProverbs)
        } else {
            ProverbsStates.OnError("Error retrieving proverbs, please check your internet connection and try again")
        }
    }

    private suspend fun retrieveFromApi(context: Context): ProverbsStates {
        val proverbs = remoteSource.get(context)
        return if (proverbs.isNotEmpty()) {
            localSource.saveAll(proverbs, true)
            val domainProverbs = proverbs.map { proverbsList -> proverbsList.toDomain() }
            ProverbsStates.OnSuccessRetrieved(domainProverbs)
        } else {
            ProverbsStates.OnError("Error retrieving proverbs, please check your internet connection and try again")
        }
    }
}
