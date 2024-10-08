package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.FavoritesDbDao
import com.example.clean_test.data.db.model.toProverbsDBData
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class LocalFavoritesDeleter @Inject constructor(private val favoritesDao: FavoritesDbDao):Deleter {

    override suspend fun deleteAllProverbs() = favoritesDao.deleteAllFavorites()

    override suspend fun deleteSingleProverb(proverb: ProverbsDataModel) {
        favoritesDao.deleteSingleFavorite(proverb.toProverbsDBData().proverb)
    }
}