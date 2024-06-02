package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.model.ProverbsDbData

interface Creator {
    suspend fun insertAll(proverbsList: List<ProverbsDbData>)
    suspend fun insertSingle(proverb: ProverbsDbData)
}