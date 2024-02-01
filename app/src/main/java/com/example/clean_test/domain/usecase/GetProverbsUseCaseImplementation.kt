package com.example.clean_test.domain.usecase

import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.domain.model.Proverbs

class GetProverbsUseCaseImplementation(private val proverbsRepository: ProverbsRepository):GetProverbsUseCase {
    override fun get():List<Proverbs> = proverbsRepository.retrieveFromSource()
}