package com.example.clean_test.data.repository.handler

import android.content.Context
import com.example.clean_test.data.repository.remote.RemoteRepositoryDataSource
import com.example.clean_test.data.model.toDomain
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.data.repository.local.LocalProverbsDataSource
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDataSourceImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetNetworkConnectionVerifierImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetProverbsRemoteDataSourceImplementationQualifier
import javax.inject.Inject

class ProverbsRepositoryHandlerImplementation @Inject constructor(@GetLocalProverbsDataSourceImplementationQualifier private val localSource: LocalProverbsDataSource,
                                                                  @GetProverbsRemoteDataSourceImplementationQualifier private val remoteSource: RemoteRepositoryDataSource,
                                                                  @GetNetworkConnectionVerifierImplementationQualifier private val networkConnectionVerifier: NetworkConnectionVerifier)
                                                : ProverbsRepositoryHandler {

    override suspend fun retrieveFromSource(context: Context): List<Proverbs> {
        return if(networkConnectionVerifier.verify()){
            val proverbs = remoteSource.get(context)
            localSource.saveAll(proverbs, true)
            proverbs.map { proverbsList -> proverbsList.toDomain() }
        }else{
            localSource.getAllProverbs().map { proverbsList -> proverbsList.toDomain() }
        }
    }
}
