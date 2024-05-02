package com.example.clean_test.domain

import android.content.Context
import com.example.clean_test.domain.entities.Proverbs

interface ProverbsRepository {
    suspend fun retrieveFromSource(context: Context):List<Proverbs>
}