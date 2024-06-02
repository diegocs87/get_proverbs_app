package com.example.clean_test.data.repository.remote

import android.content.Context
import com.example.clean_test.data.model.ProverbsDataModel

interface RemoteRepositoryDataSource {
    suspend fun get(context: Context):List<ProverbsDataModel>
}