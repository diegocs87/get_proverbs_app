package com.example.clean_test.presentation.di
import android.content.Context
import com.example.clean_test.domain.services.GetProverbsUseCase
import com.example.clean_test.domain.services.GetProverbsUseCaseImplementation

class UseCaseCreator {
    fun getProverbsUseCase(context:Context): GetProverbsUseCase {
        val proverbsRepository = ProverbsRepositoryCreator().create(context)
        return GetProverbsUseCaseImplementation(proverbsRepository)
    }
}