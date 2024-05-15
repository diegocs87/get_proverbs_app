package com.example.clean_test.data.api.service

import com.example.clean_test.data.api.model.ProverbsApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProverbsAPIService {
    @GET("test")
    suspend fun getProverbsFromApi():Response<List<ProverbsApiResponse>>
}