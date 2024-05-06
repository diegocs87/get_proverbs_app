package com.example.clean_test.frameworks_drivers.remote.model

import com.google.gson.annotations.SerializedName

data class ProverbsApiResponse(@SerializedName("proverb") val proverb: String , @SerializedName("src") val src:String)