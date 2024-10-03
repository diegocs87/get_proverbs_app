package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.FavoritesDbDao
import com.example.clean_test.data.db.model.ProverbsDbData
import javax.inject.Inject

class LocalFavoritesCreator @Inject constructor (private val favoritesDao: FavoritesDbDao):Creator {

    override suspend fun insertAll(proverbsList: List<ProverbsDbData>) = favoritesDao.insertAllFavorites(proverbsList)

    override suspend fun insertSingle(proverb: ProverbsDbData) {
        favoritesDao.insertSingleFavorite(proverb)
    }
}