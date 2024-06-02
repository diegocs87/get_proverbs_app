package com.example.clean_test.data.db.crud

interface Deleter {
    suspend fun deleteAllProverbs()
    suspend fun deleteSingleProverb(proverbId:Int)
}