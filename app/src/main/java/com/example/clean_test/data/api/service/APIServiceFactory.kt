package com.example.clean_test.data.api.service

class APIServiceFactory {
    companion object {
        private const val API_BASE_URL = "https://663822564253a866a24ce289.mockapi.io/proverbs/"
    }
    operator fun invoke():ProverbsAPIService = APIServiceProvider.invoke(API_BASE_URL).create(
        ProverbsAPIService::class.java)
}