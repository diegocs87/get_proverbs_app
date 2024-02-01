package com.example.clean_test.presentation.factory
import com.example.clean_test.domain.usecase.GetProverbsUseCase
import com.example.clean_test.domain.usecase.GetProverbsUseCaseImplementation

class UseCaseFactory {
    fun get(): GetProverbsUseCase {
        val proverbsRepository = RepositoryFactory().get()
        return GetProverbsUseCaseImplementation(proverbsRepository)
    }
}