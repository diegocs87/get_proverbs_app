package com.example.clean_test.data.api.model

import com.google.gson.annotations.SerializedName

data class ProverbsApiResponse(@SerializedName("proverb") val proverb: String , @SerializedName("src") val src:String)