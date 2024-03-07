package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.frameworks_drivers.remote.ProverbsApiProvider

class RemoteRepositoryFactory: CreateRepository {
    override fun create() = ProverbsApiProvider()
}