package com.example.clean_test.data.db.crud

import com.example.clean_test.data.model.ProverbsDataModel

interface Creator {
    suspend fun insertAll(proverbsList: List<ProverbsDataModel>)
    suspend fun insertSingle(proverb: ProverbsDataModel)
}