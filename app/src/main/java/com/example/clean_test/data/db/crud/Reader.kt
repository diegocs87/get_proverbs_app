package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.model.ProverbsDbData

interface Reader {
    suspend fun getAll():List<ProverbsDbData>
    suspend fun getSingle(proverbId: Int): ProverbsDbData?
}