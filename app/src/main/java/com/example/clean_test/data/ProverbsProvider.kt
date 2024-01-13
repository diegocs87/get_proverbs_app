package com.example.clean_test.data

import com.example.clean_test.domain.model.Proverbs

interface ProverbsProvider {
    fun getProverbs():List<Proverbs>
}