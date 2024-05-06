package com.example.clean_test.data.network

interface NetworkConnectionVerifier {
    suspend fun verify():Boolean
}