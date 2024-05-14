package com.example.clean_test.data.db.model

import com.example.clean_test.data.model.ProverbsDataModel

fun ProverbsDbData.toDataModel() = ProverbsDataModel(proverb, src)
fun ProverbsDataModel.toDB() = ProverbsDbData(proverb = proverb, src = src)
