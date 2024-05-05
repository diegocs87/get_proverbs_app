package com.example.clean_test.frameworks_drivers.remote

import android.content.Context
import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.frameworks_drivers.remote.model.toDataModel
import com.example.clean_test.frameworks_drivers.remote.service.APIServiceProvider
import com.example.clean_test.frameworks_drivers.remote.service.ProverbsAPIService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProverbsApiRepository(private val dispatcher: CoroutineDispatcher = Dispatchers.IO): ProverbsProvider {
    companion object{
        private const val API_BASE_URL = "gs://proverbsapp-84836.appspot.com/"
        val apiService: ProverbsAPIService = APIServiceProvider.invoke(API_BASE_URL).create(ProverbsAPIService::class.java)
    }
    override suspend fun get(context: Context):List<ProverbsDataModel> {
        return withContext(dispatcher){
            val response = apiService.getProverbsFromApi()
            response.body()?.map { proverbsApiResponseList -> proverbsApiResponseList.toDataModel() }?: emptyList()
        }
    }
}
