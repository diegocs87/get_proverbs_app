package com.example.clean_test.data.repository.local

import com.example.clean_test.data.model.ProverbsDataModel

interface LocalProverbsDataSource {
    suspend fun getAllProverbs():List<ProverbsDataModel>
    suspend fun getSingleProverb(proverbId: Int): ProverbsDataModel?
    suspend fun saveAll(proverbsList:List<ProverbsDataModel>,deleteBefore:Boolean)
    suspend fun saveSingle(proverb:ProverbsDataModel)
    suspend fun deleteAllProverbs()
    suspend fun deleteSingleProverb(proverbId: Int)
}