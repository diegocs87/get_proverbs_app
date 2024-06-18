package com.example.clean_test.data.di.modules

import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.data.network.NetworkConnectionVerifierImplementation
import com.example.clean_test.data.di.qualifiers.GetNetworkConnectionVerifierImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkConnectionVerifierModule {
    @Binds
    @GetNetworkConnectionVerifierImplementationQualifier
    abstract fun bindGetNetworkConnectionVerifierImpl(networkConnectionVerifierImplementation: NetworkConnectionVerifierImplementation):NetworkConnectionVerifier
}