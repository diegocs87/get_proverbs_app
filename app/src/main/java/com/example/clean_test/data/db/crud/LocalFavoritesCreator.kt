package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.FavoritesDbDao
import com.example.clean_test.data.db.model.toFavoritesDBData
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class LocalFavoritesCreator @Inject constructor (private val favoritesDao: FavoritesDbDao):Creator {

    override suspend fun insertAll(proverbsList: List<ProverbsDataModel>) {
        val favoritesListDB = proverbsList.map { currentFavorite -> currentFavorite.toFavoritesDBData() }
        favoritesDao.insertAllFavorites(favoritesListDB)
    }

    override suspend fun insertSingle(proverb: ProverbsDataModel) {
        favoritesDao.insertSingleFavorite(proverb.toFavoritesDBData())
    }
}