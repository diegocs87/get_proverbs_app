package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.repository.local.LocalProverbsDataSource

interface LocalRepositoryFactory {
    fun create():LocalProverbsDataSource
}