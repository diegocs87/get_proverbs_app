package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.ProverbsDbData

class LocalProverbsCreator(private val dbDao: ProverbsDbDao):Creator {
    override suspend fun insertAll(proverbsList: List<ProverbsDbData>) {
        dbDao.insertAllProverbs(proverbsList)
    }

    override suspend fun insertSingle(proverb: ProverbsDbData) {
        dbDao.insertSingleProverb(proverb)
    }
}