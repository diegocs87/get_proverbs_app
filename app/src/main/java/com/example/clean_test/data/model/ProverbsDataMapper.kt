package com.example.clean_test.data.model

import com.example.clean_test.domain.model.Proverbs

class ProverbsDataMapper {
    fun ProverbsDataModel.toDomain(): Proverbs = Proverbs(proverb,src)
}