package com.example.clean_test.presentation.di
import com.example.clean_test.domain.usecase.GetProverbsUseCase
import com.example.clean_test.domain.usecase.GetProverbsUseCaseImplementation

class UseCaseCreator {
    fun getProverbsUseCase(): GetProverbsUseCase {
        val proverbsRepository = ProverbsRepositoryCreator().create()
        return GetProverbsUseCaseImplementation(proverbsRepository)
    }
}