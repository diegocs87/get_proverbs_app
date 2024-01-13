package com.example.clean_test.data

import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.domain.model.Proverbs

class ProverbsRepositoryImplementation:ProverbsRepository{
    private var hasNetworkConnection = false
    private val retrieveSourceFactory: RetrieveSourceFactory = RetrieveSourceFactory()
    private lateinit var retrieveProverbsSource: RetrieveProverbs

    override fun getProverbs(): List<Proverbs> {
        retrieveProverbsSource = retrieveSourceFactory.getRetrieveSource(hasNetworkConnection)
        return retrieveProverbsSource.retrieveProverbs()
    }
}