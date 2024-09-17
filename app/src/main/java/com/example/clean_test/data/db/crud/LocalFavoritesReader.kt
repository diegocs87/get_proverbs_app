package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.FavoritesDbDao
import com.example.clean_test.data.db.model.ProverbsDbData
import com.example.clean_test.data.db.model.toDB
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class LocalFavoritesReader @Inject constructor(private val favoritesDbDao: FavoritesDbDao):Reader {
    override suspend fun getAll(): List<ProverbsDbData> {
       return emptyList()
    }

    override suspend fun getSingle(proverbId: Int): ProverbsDbData? {
        val test = ProverbsDataModel("","")
        return test.toDB()
    }

}