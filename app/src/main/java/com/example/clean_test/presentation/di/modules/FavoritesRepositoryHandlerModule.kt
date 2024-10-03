package com.example.clean_test.presentation.di.modules

import com.example.clean_test.data.repository.handler.FavoritesRepositoryHandlerImpl
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler
import com.example.clean_test.presentation.di.qualifiers.FavoritesRepositoryHandlerImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavoritesRepositoryHandlerModule {
    @Binds
    @FavoritesRepositoryHandlerImplementationQualifier
    abstract fun bindFavoritesRepositoryHandlerImplementation(favoritesRepositoryHandlerImpl: FavoritesRepositoryHandlerImpl): FavoritesRepositoryHandler
}