package com.example.clean_test.domain.usecases

import com.example.clean_test.data.db.model.toData
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler
import com.example.clean_test.presentation.di.qualifiers.FavoritesRepositoryHandlerImplementationQualifier
import javax.inject.Inject

class RemoveFavoriteImplementation @Inject constructor (@FavoritesRepositoryHandlerImplementationQualifier private val favoritesRepositoryHandler: FavoritesRepositoryHandler): RemoveFavorite {
    override suspend fun invoke(proverb: Proverbs) {
        favoritesRepositoryHandler.deleteSingle(proverb.toData())
    }
}