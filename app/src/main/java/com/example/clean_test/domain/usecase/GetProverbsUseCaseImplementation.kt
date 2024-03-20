package com.example.clean_test.domain.usecase

import android.content.Context
import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.domain.model.Proverbs

class GetProverbsUseCaseImplementation(private val proverbsRepository: ProverbsRepository):GetProverbsUseCase {
    override suspend fun get(context: Context):List<Proverbs> = proverbsRepository.retrieveFromSource(context)
}