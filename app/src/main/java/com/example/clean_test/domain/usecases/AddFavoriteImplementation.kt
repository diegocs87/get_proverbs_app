package com.example.clean_test.domain.usecases

import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler
import com.example.clean_test.presentation.di.qualifiers.FavoritesRepositoryHandlerImplementationQualifier
import javax.inject.Inject

class AddFavoriteImplementation @Inject constructor (@FavoritesRepositoryHandlerImplementationQualifier private val favoritesRepositoryHandler: FavoritesRepositoryHandler): AddFavorite {
    override suspend fun invoke(favorite: Proverbs) {
        favoritesRepositoryHandler.add(favorite)
    }
}