package com.example.clean_test.frameworks_drivers.remote.service

import com.example.clean_test.frameworks_drivers.remote.model.ProverbsApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProverbsAPIService {
    @GET("proverbs.json")
    suspend fun getProverbsFromApi():Response<List<ProverbsApiResponse>>
}