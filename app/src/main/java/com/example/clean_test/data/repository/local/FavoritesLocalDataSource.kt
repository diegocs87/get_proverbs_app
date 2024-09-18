package com.example.clean_test.data.repository.local

import com.example.clean_test.data.model.ProverbsDataModel

class FavoritesLocalDataSource:LocalDataSource {
    override suspend fun getAll(): List<ProverbsDataModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingle(proverbId: Int): ProverbsDataModel? {
        TODO("Not yet implemented")
    }

    override suspend fun saveAll(proverbsList: List<ProverbsDataModel>, deleteBefore: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun saveSingle(proverb: ProverbsDataModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSingle(proverbId: Int) {
        TODO("Not yet implemented")
    }
}