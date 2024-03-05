package com.example.clean_test.data

import com.example.clean_test.data.model.ProverbsDataModel

class RetrieveProverbsFromDB(private val proverbsDbProvider: ProverbsProvider): RetrieveProverbs {
    override fun retrieveProverbs():List<ProverbsDataModel> {
        return emptyList()
    }
}