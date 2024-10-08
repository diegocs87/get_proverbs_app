package com.example.clean_test.data.repository.handler

import com.example.clean_test.data.db.model.toData
import com.example.clean_test.data.di.qualifiers.GetFavoritesLocalDataSourceImplementationQualifier
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.data.model.toDomain
import com.example.clean_test.data.repository.local.LocalDataSource
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler
import javax.inject.Inject

class FavoritesRepositoryHandlerImpl @Inject constructor(@GetFavoritesLocalDataSourceImplementationQualifier private val favoritesSource: LocalDataSource): FavoritesRepositoryHandler {

    override suspend fun add(favorite: Proverbs) {
        favoritesSource.saveSingle(favorite.toData())
    }

    override suspend fun getAll(): List<Proverbs> = favoritesSource.getAll().map { favorite -> favorite.toDomain() }

    override suspend fun deleteSingle(proverb: ProverbsDataModel) = favoritesSource.deleteSingle(proverb)

    override suspend fun deleteAll() = favoritesSource.deleteAll()
}