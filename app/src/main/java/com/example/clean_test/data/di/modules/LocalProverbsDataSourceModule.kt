package com.example.clean_test.data.di.modules

import com.example.clean_test.data.repository.local.LocalDataSource
import com.example.clean_test.data.repository.local.ProverbsLocalDataSource
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDataSourceImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalProverbsDataSourceModule {
    @Binds
    @GetLocalProverbsDataSourceImplementationQualifier
    abstract fun bindGetLocalProverbsDataSourceImplementation(localProverbsDataSourceImpl: ProverbsLocalDataSource): LocalDataSource
}