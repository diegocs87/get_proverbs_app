package com.example.clean_test.presentation.di.modules

import com.example.clean_test.domain.usecases.RemoveFavorite
import com.example.clean_test.domain.usecases.RemoveFavoriteImplementation
import com.example.clean_test.presentation.di.qualifiers.RemoveFavoriteUseCaseImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoveFavoriteUseCaseModule {

    @Binds
    @RemoveFavoriteUseCaseImplementationQualifier
    abstract fun bindRemoveFavoriteUseCaseImplementation(removeFavoriteUseCaseImpl: RemoveFavoriteImplementation): RemoveFavorite
}