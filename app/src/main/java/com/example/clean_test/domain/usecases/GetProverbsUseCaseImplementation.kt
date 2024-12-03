package com.example.clean_test.domain.usecases

import android.content.Context
import com.example.clean_test.domain.entities.ProverbsStates
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.presentation.di.qualifiers.ProverbsRepositoryHandlerImplementationQualifier
import javax.inject.Inject

class GetProverbsUseCaseImplementation
    @Inject constructor(@ProverbsRepositoryHandlerImplementationQualifier private val proverbsRepositoryHandler: ProverbsRepositoryHandler)
    : GetProverbsUseCase {
    override suspend fun get(context: Context):ProverbsStates = proverbsRepositoryHandler.retrieveFromSource(context)
}