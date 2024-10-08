package com.example.clean_test.data.di.modules

import com.example.clean_test.data.db.crud.Creator
import com.example.clean_test.data.db.crud.LocalFavoritesCreator
import com.example.clean_test.data.di.qualifiers.GetLocalFavoritesCreatorImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalFavoritesCreatorModule {
    @Binds
    @GetLocalFavoritesCreatorImplementationQualifier
    abstract fun bindGetLocalFavoritesCreatorImplementation(localFavoritesCreator: LocalFavoritesCreator): Creator
}