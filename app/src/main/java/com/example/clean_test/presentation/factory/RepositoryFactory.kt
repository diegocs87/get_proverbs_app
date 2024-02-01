package com.example.clean_test.presentation.factory

import com.example.clean_test.data.ProverbsRepositoryImplementation
import com.example.clean_test.data.network.NetworkConnectionVerifierImplementation
import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.frameworks_drivers.cache.ProverbsDbProvider
import com.example.clean_test.frameworks_drivers.remote.ProverbsApiProvider

class RepositoryFactory {
    fun get(): ProverbsRepository {
        val networkConnectionVerifier = NetworkConnectionVerifierImplementation()
        val remoteSource = ProverbsApiProvider()
        val localSource = ProverbsDbProvider()
        return ProverbsRepositoryImplementation(localSource,remoteSource,networkConnectionVerifier)
    }
}