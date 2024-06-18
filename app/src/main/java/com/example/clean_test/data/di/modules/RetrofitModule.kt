package com.example.clean_test.data.di.modules

import com.example.clean_test.data.api.service.ProverbsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val API_BASE_URL = "https://663822564253a866a24ce289.mockapi.io/proverbs/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(API_BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideProverbsApiService(retrofit: Retrofit):ProverbsAPIService = retrofit.create(ProverbsAPIService::class.java)
}