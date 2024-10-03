package com.example.clean_test.data.db.model

import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.domain.entities.Proverbs

fun ProverbsDataModel.toFavoritesDBData() = FavoriteDbData(proverb = proverb, src = src)
fun FavoriteDbData.toDataModel() = ProverbsDataModel(proverb,src)
fun ProverbsDbData.toDataModel() = ProverbsDataModel(proverb, src)
fun ProverbsDataModel.toProverbsDBData() = ProverbsDbData(proverb = proverb, src = src)
fun Proverbs.toData() = ProverbsDataModel(proverb = proverb, src = src)
