package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.repository.remote.ProverbsRemoteDataSource

class RemoteRepositoryFactory: CreateRepository {
    override fun create() = ProverbsRemoteDataSource()
}