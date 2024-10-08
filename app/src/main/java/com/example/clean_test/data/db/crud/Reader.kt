package com.example.clean_test.data.db.crud

import com.example.clean_test.data.model.ProverbsDataModel

interface Reader {
    suspend fun getAll():List<ProverbsDataModel>
    suspend fun getSingle(proverbId: Int): ProverbsDataModel?
}