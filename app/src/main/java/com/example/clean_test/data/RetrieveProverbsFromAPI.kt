package com.example.clean_test.data


import com.example.clean_test.data.model.ProverbsDataModel

class RetrieveProverbsFromAPI(private val proverbsApiProvider: ProverbsProvider): RetrieveProverbs {
    override fun retrieveProverbs():List<ProverbsDataModel> {
        //return proverbsApiProvider.get()
        return emptyList()
    }
}