package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.repository.remote.RemoteRepositoryDataSource

interface RemoteRepositoryFactory {
    fun create(): RemoteRepositoryDataSource
}