package com.example.clean_test.data

import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.data.RetrieveProverbs
import com.example.clean_test.domain.model.Proverbs

class RetrieveProverbsFromDB(private val proverbsDbProvider: ProverbsProvider): RetrieveProverbs {
    override fun retrieveProverbs():List<Proverbs> {
        return proverbsDbProvider.getProverbs()
    }
}