package com.example.clean_test.domain.usecases

import com.example.clean_test.domain.entities.Proverbs

interface AddFavorite {
    operator fun invoke(proverb: Proverbs)
}