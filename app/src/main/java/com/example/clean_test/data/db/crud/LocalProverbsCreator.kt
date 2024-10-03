package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.toProverbsDBData
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class LocalProverbsCreator @Inject constructor (private val dbDao: ProverbsDbDao):Creator {
    override suspend fun insertAll(proverbsList: List<ProverbsDataModel>) {
        val proverbsDbList = proverbsList.map { currentProverb -> currentProverb.toProverbsDBData() }
        dbDao.insertAllProverbs(proverbsDbList)
    }

    override suspend fun insertSingle(proverb: ProverbsDataModel) {
        dbDao.insertSingleProverb(proverb.toProverbsDBData())
    }
}