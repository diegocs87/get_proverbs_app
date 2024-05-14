package com.example.clean_test.domain.services

import android.content.Context
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.domain.entities.Proverbs

class GetProverbsUseCaseImplementation(private val proverbsRepositoryHandler: ProverbsRepositoryHandler):GetProverbsUseCase {
    override suspend fun get(context: Context):List<Proverbs> = proverbsRepositoryHandler.retrieveFromSource(context)
}