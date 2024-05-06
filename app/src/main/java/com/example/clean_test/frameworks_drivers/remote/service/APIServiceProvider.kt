package com.example.clean_test.frameworks_drivers.remote.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIServiceProvider {
    operator fun invoke(baseUrl:String):Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
}