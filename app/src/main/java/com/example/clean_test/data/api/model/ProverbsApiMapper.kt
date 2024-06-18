package com.example.clean_test.data.api.model

import com.example.clean_test.data.model.ProverbsDataModel

fun ProverbsApiResponse.toDataModel() = ProverbsDataModel(proverb, src)