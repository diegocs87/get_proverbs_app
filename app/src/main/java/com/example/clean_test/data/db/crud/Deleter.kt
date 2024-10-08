package com.example.clean_test.data.db.crud

import com.example.clean_test.data.model.ProverbsDataModel

interface Deleter {
    suspend fun deleteAllProverbs()
    suspend fun deleteSingleProverb(proverb: ProverbsDataModel)
}