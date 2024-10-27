package com.example.clean_test.presentation.di.modules

import com.example.clean_test.domain.usecases.GetFavorites
import com.example.clean_test.domain.usecases.GetFavoritesImpl
import com.example.clean_test.presentation.di.qualifiers.GetFavoritesUseCaseImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GetFavoritesUseCaseModule {
    @Binds
    @GetFavoritesUseCaseImplementationQualifier
    abstract fun bindGetFavoritesUseCaseImplementation(getFavoritesUseCaseImpl: GetFavoritesImpl): GetFavorites
}