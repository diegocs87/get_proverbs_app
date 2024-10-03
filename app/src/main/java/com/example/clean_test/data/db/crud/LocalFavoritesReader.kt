package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.FavoritesDbDao
import com.example.clean_test.data.db.model.ProverbsDbData
import javax.inject.Inject

class LocalFavoritesReader @Inject constructor(private val favoritesDbDao: FavoritesDbDao):Reader {

    override suspend fun getAll(): List<ProverbsDbData> = favoritesDbDao.getAllFavorites()

    override suspend fun getSingle(proverbId: Int): ProverbsDbData? = favoritesDbDao.getSingleFavorite(proverbId)
}