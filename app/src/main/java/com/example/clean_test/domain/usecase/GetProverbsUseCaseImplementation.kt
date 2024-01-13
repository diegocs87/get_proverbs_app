package com.example.clean_test.domain.usecase

import com.example.clean_test.domain.ProverbsRepository

class GetProverbsUseCaseImplementation(private val proverbsRepository: ProverbsRepository):GetProverbsUseCase {
    override fun getProverbs() =  proverbsRepository.getProverbs()
}