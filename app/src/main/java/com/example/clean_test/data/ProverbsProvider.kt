package com.example.clean_test.data

import android.content.Context
import com.example.clean_test.data.model.ProverbsDataModel

interface ProverbsProvider {
    suspend fun get(context: Context):List<ProverbsDataModel>
}