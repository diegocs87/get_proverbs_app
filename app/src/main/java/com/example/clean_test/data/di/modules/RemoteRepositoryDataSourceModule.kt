package com.example.clean_test.data.di.modules

import com.example.clean_test.data.repository.remote.ProverbsRemoteDataSource
import com.example.clean_test.data.repository.remote.RemoteRepositoryDataSource
import com.example.clean_test.data.di.qualifiers.GetProverbsRemoteDataSourceImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteRepositoryDataSourceModule {

    @Binds
    @GetProverbsRemoteDataSourceImplementationQualifier
    abstract fun bindGetProverbsRemoteDataSourceImplementation(remoteDataSourceImplementation:ProverbsRemoteDataSource): RemoteRepositoryDataSource
}