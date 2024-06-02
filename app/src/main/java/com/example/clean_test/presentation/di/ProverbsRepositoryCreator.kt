package com.example.clean_test.presentation.di

import android.content.Context
import com.example.clean_test.data.repository.handler.ProverbsRepositoryHandlerImplementation
import com.example.clean_test.data.network.NetworkConnectionVerifierImplementation
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.data.repository.factory.LocalRepositoryFactoryImpl
import com.example.clean_test.data.repository.factory.RemoteRepositoryFactoryImpl

class ProverbsRepositoryCreator {
    fun create(context: Context): ProverbsRepositoryHandler {
        val networkConnectionVerifier = NetworkConnectionVerifierImplementation()
        val remoteRepository= RemoteRepositoryFactoryImpl()
        val localRepository = LocalRepositoryFactoryImpl(context)
        return ProverbsRepositoryHandlerImplementation(localRepository.create(),remoteRepository.create(),networkConnectionVerifier)
    }
}