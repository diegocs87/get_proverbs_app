package com.example.clean_test.data.repository.factory

import com.example.clean_test.frameworks_drivers.remote.ProverbsApiRepository

class RemoteRepositoryFactory: CreateRepository {
    override fun create() = ProverbsApiRepository()
}