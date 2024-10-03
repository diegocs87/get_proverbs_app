package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.FavoritesDbDao
import com.example.clean_test.data.db.model.toDataModel
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class LocalFavoritesReader @Inject constructor(private val favoritesDbDao: FavoritesDbDao):Reader {

    override suspend fun getAll(): List<ProverbsDataModel> = favoritesDbDao.getAllFavorites().map { currentFavorite -> currentFavorite.toDataModel() }

    override suspend fun getSingle(proverbId: Int): ProverbsDataModel? = favoritesDbDao.getSingleFavorite(proverbId).let { currentProverb -> currentProverb?.toDataModel() }
}