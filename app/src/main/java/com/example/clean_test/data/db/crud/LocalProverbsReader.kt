package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.toDataModel
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class LocalProverbsReader @Inject constructor(private val dbDao: ProverbsDbDao):Reader {

    override suspend fun getAll(): List<ProverbsDataModel> {
        val proverbsListFromDB = dbDao.getAllProverbs()
        return proverbsListFromDB.map { currentProverb -> currentProverb.toDataModel() }
    }

    override suspend fun getSingle(proverbId: Int): ProverbsDataModel? = dbDao.getSingleProverb(proverbId).let { currentProverb ->  currentProverb?.toDataModel()}
}