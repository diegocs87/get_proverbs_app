package com.example.clean_test.domain.usecase

import com.example.clean_test.domain.model.Proverbs

interface GetProverbsUseCase {
    fun get():List<Proverbs>
}