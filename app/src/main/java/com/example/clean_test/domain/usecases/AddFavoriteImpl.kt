package com.example.clean_test.domain.usecases

import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler

class AddFavoriteImpl(private val favoritesRepositoryHandler: FavoritesRepositoryHandler): AddFavorite {
    override suspend fun invoke(favorite: Proverbs) {
        favoritesRepositoryHandler.add(favorite)
    }
}