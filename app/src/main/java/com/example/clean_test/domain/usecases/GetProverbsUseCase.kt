package com.example.clean_test.domain.usecases

import android.content.Context
import com.example.clean_test.domain.entities.ProverbsStates

interface GetProverbsUseCase {
    suspend fun get(context: Context): ProverbsStates
}