package com.example.clean_test.presentation.di

import com.example.clean_test.data.repository.ProverbsRepositoryImplementation
import com.example.clean_test.data.network.NetworkConnectionVerifierImplementation
import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.data.repository.factory.LocalRepositoryFactory
import com.example.clean_test.data.repository.factory.RemoteRepositoryFactory

class ProverbsRepositoryCreator {
    fun create(): ProverbsRepository {
        val networkConnectionVerifier = NetworkConnectionVerifierImplementation()
        val remoteRepository= RemoteRepositoryFactory()
        val localRepository = LocalRepositoryFactory()
        return ProverbsRepositoryImplementation(localRepository.create(),remoteRepository.create(),networkConnectionVerifier)
    }
}