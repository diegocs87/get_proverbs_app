package com.example.clean_test.presentation.di.modules

import com.example.clean_test.domain.services.GetProverbsUseCase
import com.example.clean_test.domain.services.GetProverbsUseCaseImplementation
import com.example.clean_test.presentation.di.qualifiers.GetProverbsUseCaseImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProverbsInterfaceModule {

    @Binds
    @GetProverbsUseCaseImplementationQualifier
    abstract fun bindGetProverbsUseCaseImplementation(getProverbsUseCaseImpl: GetProverbsUseCaseImplementation): GetProverbsUseCase
}