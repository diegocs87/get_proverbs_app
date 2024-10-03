package com.example.clean_test.domain.repository

import com.example.clean_test.domain.entities.Proverbs

interface FavoritesRepositoryHandler {
    suspend fun add(favorite: Proverbs)
    suspend fun getAll():List<Proverbs>
    suspend fun deleteSingle(favoriteId: Int)
    suspend fun deleteAll()
}