package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.ProverbsDbData

class LocalProverbsReader(private val dbDao: ProverbsDbDao):Reader {

    override suspend fun getAll() = dbDao.getAllProverbs()

    override suspend fun getSingle(proverbId: Int): ProverbsDbData? = dbDao.getSingleProverb(proverbId)
}