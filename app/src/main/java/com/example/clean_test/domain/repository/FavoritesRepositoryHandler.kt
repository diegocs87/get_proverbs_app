package com.example.clean_test.domain.repository

import com.example.clean_test.data.model.ProverbsDataModel

interface FavoritesRepositoryHandler {
    suspend fun add(favorite:ProverbsDataModel)
    suspend fun getAll():List<ProverbsDataModel>
    suspend fun deleteSingle(favoriteId: Int)
    suspend fun deleteAll()
}