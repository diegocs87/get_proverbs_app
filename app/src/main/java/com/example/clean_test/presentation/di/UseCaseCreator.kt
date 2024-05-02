package com.example.clean_test.presentation.di
import com.example.clean_test.domain.services.GetProverbsUseCase
import com.example.clean_test.domain.services.GetProverbsUseCaseImplementation

class UseCaseCreator {
    fun getProverbsUseCase(): GetProverbsUseCase {
        val proverbsRepository = ProverbsRepositoryCreator().create()
        return GetProverbsUseCaseImplementation(proverbsRepository)
    }
}