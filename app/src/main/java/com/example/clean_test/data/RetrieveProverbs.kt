package com.example.clean_test.data

import com.example.clean_test.domain.model.Proverbs

interface RetrieveProverbs {
    fun retrieveProverbs():List<Proverbs>
}