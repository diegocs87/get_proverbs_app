package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.toProverbsDBData
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class LocalProverbsDeleter @Inject constructor(private val dbDao: ProverbsDbDao):Deleter {

    override suspend fun deleteAllProverbs() {
        dbDao.deleteAllProverbs()
    }

    override suspend fun deleteSingleProverb(proverb: ProverbsDataModel) {
        dbDao.deleteSingleProverb(proverb.toProverbsDBData().id)
    }

}