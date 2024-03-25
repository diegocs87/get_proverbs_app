package com.example.clean_test.data.network

import android.content.Context

interface NetworkConnectionVerifier {
    suspend fun verify(context: Context):Boolean
}