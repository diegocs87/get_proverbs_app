package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.frameworks_drivers.cache.ProverbsDbProvider

class LocalRepositoryFactory: CreateRepository {
    override fun create():ProverbsProvider = ProverbsDbProvider()
}