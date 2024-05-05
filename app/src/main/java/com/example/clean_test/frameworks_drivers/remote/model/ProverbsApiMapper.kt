package com.example.clean_test.frameworks_drivers.remote.model

import com.example.clean_test.data.model.ProverbsDataModel

fun ProverbsApiResponse.toDataModel() = ProverbsDataModel(proverb, src)
fun ProverbsDataModel.toApi() = ProverbsApiResponse(proverb = proverb, src = src)
