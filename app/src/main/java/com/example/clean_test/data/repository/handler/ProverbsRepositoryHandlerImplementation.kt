package com.example.clean_test.data.repository.handler

import android.content.Context
import com.example.clean_test.data.ProverbsDataSource
import com.example.clean_test.data.model.toDomain
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.domain.entities.Proverbs

    class ProverbsRepositoryHandlerImplementation(private val localSource: ProverbsDataSource,
                                                  private val remoteSource: ProverbsDataSource,
                                                  private val networkConnectionVerifier: NetworkConnectionVerifier):
        ProverbsRepositoryHandler {
    override suspend fun retrieveFromSource(context: Context): List<Proverbs> {
        return if(networkConnectionVerifier.verify()){
            remoteSource.get(context).map { proverbsList -> proverbsList.toDomain() }
        }else{
            localSource.get(context).map { proverbsList -> proverbsList.toDomain() }
        }
    }
}
