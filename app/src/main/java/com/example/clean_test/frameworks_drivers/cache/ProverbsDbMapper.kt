package com.example.clean_test.frameworks_drivers.cache

import com.example.clean_test.frameworks_drivers.cache.model.ProverbsDbModel
import com.example.clean_test.data.model.ProverbsDataModel

class ProverbsDbMapper {
    fun ProverbsDbModel.toDataModel() = ProverbsDataModel(proverb, src)
    fun ProverbsDataModel.toDB() = ProverbsDbModel(proverb = proverb, src = src)
}