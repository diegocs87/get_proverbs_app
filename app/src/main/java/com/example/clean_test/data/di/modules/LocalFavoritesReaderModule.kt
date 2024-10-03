package com.example.clean_test.data.di.modules

import com.example.clean_test.data.db.crud.LocalFavoritesReader
import com.example.clean_test.data.db.crud.Reader
import com.example.clean_test.data.di.qualifiers.GetLocalFavoritesReaderImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalFavoritesReaderModule {
    @Binds
    @GetLocalFavoritesReaderImplementationQualifier
    abstract fun bindGetLocalFavoritesReaderImplementation(localFavoritesReader : LocalFavoritesReader): Reader
}