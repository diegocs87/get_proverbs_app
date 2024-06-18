package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import javax.inject.Inject

class LocalProverbsDeleter @Inject constructor(private val dbDao: ProverbsDbDao):Deleter {

    override suspend fun deleteAllProverbs() {
        dbDao.deleteAllProverbs()
    }

    override suspend fun deleteSingleProverb(proverbId:Int) {
        dbDao.deleteSingleProverb(proverbId)
    }

}