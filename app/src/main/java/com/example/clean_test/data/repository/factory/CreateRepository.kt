package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.ProverbsDataSource

interface CreateRepository {
    fun create():ProverbsDataSource
}