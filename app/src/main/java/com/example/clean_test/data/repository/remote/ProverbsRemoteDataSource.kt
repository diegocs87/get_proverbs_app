package com.example.clean_test.data.repository.remote

import android.content.Context
import com.example.clean_test.data.api.model.toDataModel
import com.example.clean_test.data.api.service.ProverbsAPIService
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.presentation.di.qualifiers.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProverbsRemoteDataSource @Inject constructor(@IODispatcher private val dispatcher: CoroutineDispatcher,
                                                   private val apiService: ProverbsAPIService): RemoteRepositoryDataSource {

    override suspend fun get(context: Context):List<ProverbsDataModel> {
        return withContext(dispatcher){
            val response = apiService.getProverbsFromApi()
            response.body()?.map { proverbsApiResponseList -> proverbsApiResponseList.toDataModel() }?: emptyList()
        }
    }
}
