package com.example.clean_test.domain.services

import android.content.Context
import com.example.clean_test.domain.entities.Proverbs

interface GetProverbsUseCase {
    suspend fun get(context: Context):List<Proverbs>
}