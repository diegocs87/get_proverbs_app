package com.example.clean_test.domain.usecases

import com.example.clean_test.domain.entities.Proverbs

interface GetFavorites {
    suspend operator fun invoke():List<Proverbs>
}