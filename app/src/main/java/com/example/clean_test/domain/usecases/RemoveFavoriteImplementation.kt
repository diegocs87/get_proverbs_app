package com.example.clean_test.domain.usecases

import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.presentation.di.qualifiers.ProverbsRepositoryHandlerImplementationQualifier

class RemoveFavoriteImplementation(@ProverbsRepositoryHandlerImplementationQualifier private val proverbsRepositoryHandler: ProverbsRepositoryHandler): RemoveFavorite {
    override fun invoke(proverb: Proverbs) {
        TODO("Not yet implemented")
    }
}