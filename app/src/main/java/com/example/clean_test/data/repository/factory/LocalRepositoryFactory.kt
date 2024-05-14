package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.ProverbsDataSource
import com.example.clean_test.data.repository.local.ProverbsLocalDataSource

class LocalRepositoryFactory: CreateRepository {
    override fun create():ProverbsDataSource = ProverbsLocalDataSource()
}