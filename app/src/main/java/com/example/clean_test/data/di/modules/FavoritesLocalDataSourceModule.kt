package com.example.clean_test.data.di.modules

import com.example.clean_test.data.di.qualifiers.GetFavoritesLocalDataSourceImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDataSourceImplementationQualifier
import com.example.clean_test.data.repository.local.FavoritesLocalDataSource
import com.example.clean_test.data.repository.local.LocalDataSource
import com.example.clean_test.data.repository.local.ProverbsLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavoritesLocalDataSourceModule {
    @Binds
    @GetFavoritesLocalDataSourceImplementationQualifier
    abstract fun bindGetFavoritesLocalDataSourceImplementation(favoritesLocalDataSourceImpl: FavoritesLocalDataSource): LocalDataSource
}