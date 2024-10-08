package com.example.clean_test.domain.usecases

import com.example.clean_test.domain.entities.Proverbs

interface RemoveFavorite {
    suspend operator fun invoke(proverb: Proverbs)
}