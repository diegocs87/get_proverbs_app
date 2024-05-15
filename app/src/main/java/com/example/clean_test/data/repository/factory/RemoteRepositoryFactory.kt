package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.api.service.APIServiceFactory
import com.example.clean_test.data.repository.remote.ProverbsRemoteDataSource

class RemoteRepositoryFactory: CreateRepository {
    private val apiServiceFactory = APIServiceFactory()
    override fun create() = ProverbsRemoteDataSource(apiService = apiServiceFactory())
}