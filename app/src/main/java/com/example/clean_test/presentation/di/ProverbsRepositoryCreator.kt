package com.example.clean_test.presentation.di

import com.example.clean_test.data.repository.handler.ProverbsRepositoryHandlerImplementation
import com.example.clean_test.data.network.NetworkConnectionVerifierImplementation
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.data.repository.factory.LocalRepositoryFactory
import com.example.clean_test.data.repository.factory.RemoteRepositoryFactory

class ProverbsRepositoryCreator {
    fun create(): ProverbsRepositoryHandler {
        val networkConnectionVerifier = NetworkConnectionVerifierImplementation()
        val remoteRepository= RemoteRepositoryFactory()
        val localRepository = LocalRepositoryFactory()
        return ProverbsRepositoryHandlerImplementation(localRepository.create(),remoteRepository.create(),networkConnectionVerifier)
    }
}