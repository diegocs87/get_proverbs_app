package com.example.clean_test.data.db.model

import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.domain.entities.Proverbs

fun ProverbsDbData.toDataModel() = ProverbsDataModel(proverb, src)
fun ProverbsDataModel.toDB() = ProverbsDbData(proverb = proverb, src = src)
fun Proverbs.toData() = ProverbsDataModel(proverb = proverb, src = src)
