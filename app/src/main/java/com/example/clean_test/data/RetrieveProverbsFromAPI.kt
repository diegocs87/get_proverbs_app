package com.example.clean_test.data


import com.example.clean_test.domain.model.Proverbs

class RetrieveProverbsFromAPI(private val proverbsApiProvider: ProverbsProvider): RetrieveProverbs {
    override fun retrieveProverbs():List<Proverbs> {
        return proverbsApiProvider.getProverbs()
    }
}