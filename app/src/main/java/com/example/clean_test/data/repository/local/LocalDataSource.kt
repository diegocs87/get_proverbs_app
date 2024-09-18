package com.example.clean_test.data.repository.local

import com.example.clean_test.data.model.ProverbsDataModel

interface LocalDataSource {
    suspend fun getAll():List<ProverbsDataModel>
    suspend fun getSingle(proverbId: Int): ProverbsDataModel?
    suspend fun saveAll(proverbsList:List<ProverbsDataModel>,deleteBefore:Boolean)
    suspend fun saveSingle(proverb:ProverbsDataModel)
    suspend fun deleteAll()
    suspend fun deleteSingle(proverbId: Int)
}