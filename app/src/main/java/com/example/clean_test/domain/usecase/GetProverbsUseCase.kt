package com.example.clean_test.domain.usecase

import android.content.Context
import com.example.clean_test.domain.model.Proverbs

interface GetProverbsUseCase {
    suspend fun get(context: Context):List<Proverbs>
}