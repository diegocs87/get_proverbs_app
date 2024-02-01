package com.example.clean_test.domain

import com.example.clean_test.domain.model.Proverbs

interface ProverbsRepository {
    fun retrieveFromSource():List<Proverbs>
}