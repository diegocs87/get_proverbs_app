package com.example.clean_test.data.repository

import android.content.Context
import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.data.model.toDomain
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.domain.model.Proverbs

    class ProverbsRepositoryImplementation(private val localSource: ProverbsProvider,
                                       private val remoteSource: ProverbsProvider,
                                       private val networkConnectionVerifier: NetworkConnectionVerifier):ProverbsRepository {
    override suspend fun retrieveFromSource(context: Context): List<Proverbs> {
        return if(networkConnectionVerifier.verify()){
            remoteSource.get(context).map { proverbsList -> proverbsList.toDomain() }
        }else{
            localSource.get(context).map { proverbsList -> proverbsList.toDomain() }
        }
    }
}
