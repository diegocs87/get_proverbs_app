package com.example.clean_test.data

import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.domain.model.Proverbs

class ProverbsRepositoryImplementation(private val localSource:ProverbsProvider,
                                       private val remoteSource:ProverbsProvider,
                                       private val networkConnectionVerifier: NetworkConnectionVerifier
):ProverbsRepository {
    override fun retrieveFromSource(): List<Proverbs> {
        return if(networkConnectionVerifier.verify()){
            remoteSource.getProverbs()
        }else{
            localSource.getProverbs()
        }
    }
}
