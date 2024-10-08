package com.example.clean_test.presentation.di.modules

import com.example.clean_test.domain.usecases.AddFavorite
import com.example.clean_test.domain.usecases.AddFavoriteImplementation
import com.example.clean_test.presentation.di.qualifiers.AddFavoriteUseCaseImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AddFavoriteUseCaseModule {
    @Binds
    @AddFavoriteUseCaseImplementationQualifier
    abstract fun bindAddFavoriteUseCaseImplementation(addFavoriteUseCaseImpl: AddFavoriteImplementation): AddFavorite
}