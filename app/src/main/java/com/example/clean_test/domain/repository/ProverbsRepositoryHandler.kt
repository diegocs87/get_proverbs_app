package com.example.clean_test.domain.repository

import android.content.Context
import com.example.clean_test.domain.entities.ProverbsStates

interface ProverbsRepositoryHandler {
    suspend fun retrieveFromSource(context: Context):ProverbsStates
}