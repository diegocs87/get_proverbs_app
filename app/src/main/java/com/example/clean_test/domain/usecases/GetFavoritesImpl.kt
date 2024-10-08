package com.example.clean_test.domain.usecases

import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler
import com.example.clean_test.presentation.di.qualifiers.FavoritesRepositoryHandlerImplementationQualifier
import javax.inject.Inject

class GetFavoritesImpl @Inject constructor (@FavoritesRepositoryHandlerImplementationQualifier private val favoritesRepositoryHandler: FavoritesRepositoryHandler):GetFavorites {
    override suspend fun invoke(): List<Proverbs> = favoritesRepositoryHandler.getAll()
}