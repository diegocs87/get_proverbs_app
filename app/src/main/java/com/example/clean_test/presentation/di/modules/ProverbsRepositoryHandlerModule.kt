package com.example.clean_test.presentation.di.modules

import com.example.clean_test.data.repository.handler.ProverbsRepositoryHandlerImplementation
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.presentation.di.qualifiers.ProverbsRepositoryHandlerImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProverbsRepositoryHandlerModule {
    @Binds
    @ProverbsRepositoryHandlerImplementationQualifier
    abstract fun bindProverbsRepositoryHandlerImplementation(proverbsRepositoryHandlerImpl: ProverbsRepositoryHandlerImplementation): ProverbsRepositoryHandler
}