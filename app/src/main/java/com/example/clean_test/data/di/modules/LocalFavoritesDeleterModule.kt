package com.example.clean_test.data.di.modules

import com.example.clean_test.data.db.crud.Deleter
import com.example.clean_test.data.db.crud.LocalFavoritesDeleter
import com.example.clean_test.data.di.qualifiers.GetLocalFavoritesDeleterImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalFavoritesDeleterModule {
    @Binds
    @GetLocalFavoritesDeleterImplementationQualifier
    abstract fun bindGetLocalFavoritesDeleterImplementation(localFavoritesDeleter : LocalFavoritesDeleter): Deleter
}