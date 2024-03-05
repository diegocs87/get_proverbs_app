package com.example.clean_test.data

import com.example.clean_test.data.model.ProverbsDataModel

interface RetrieveProverbs {
    fun retrieveProverbs():List<ProverbsDataModel>
}