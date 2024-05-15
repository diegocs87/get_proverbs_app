package com.example.clean_test.data.repository.remote

import android.content.Context
import com.example.clean_test.data.ProverbsDataSource
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.data.api.model.toDataModel
import com.example.clean_test.data.api.service.APIServiceProvider
import com.example.clean_test.data.api.service.ProverbsAPIService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProverbsRemoteDataSource(private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
                               private val apiService: ProverbsAPIService): ProverbsDataSource {

    override suspend fun get(context: Context):List<ProverbsDataModel> {
        return withContext(dispatcher){
            val response = apiService.getProverbsFromApi()
            response.body()?.map { proverbsApiResponseList -> proverbsApiResponseList.toDataModel() }?: emptyList()
        }
    }
}
