package com.example.clean_test.data

import com.example.clean_test.cache.ProverbsDbProvider
import com.example.clean_test.remote.ProverbsApiProvider

class RetrieveSourceFactory {

    fun getRetrieveSource(hasNetwork:Boolean): RetrieveProverbs {
        return if(hasNetwork) {
            RetrieveProverbsFromAPI(ProverbsApiProvider())
        }else{
            RetrieveProverbsFromDB(ProverbsDbProvider())
        }
    }
}