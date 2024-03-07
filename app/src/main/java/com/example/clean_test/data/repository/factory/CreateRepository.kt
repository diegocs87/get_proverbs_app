package com.example.clean_test.data.repository.factory

import com.example.clean_test.data.ProverbsProvider

interface CreateRepository {
    fun create():ProverbsProvider
}