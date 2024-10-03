package com.example.clean_test.data.repository.handler

import com.example.clean_test.data.db.model.toData
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDataSourceImplementationQualifier
import com.example.clean_test.data.model.toDomain
import com.example.clean_test.data.repository.local.LocalDataSource
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler
import javax.inject.Inject

class FavoritesRepositoryHandlerImpl @Inject constructor(@GetLocalProverbsDataSourceImplementationQualifier private val favoritesSource: LocalDataSource): FavoritesRepositoryHandler {

    override suspend fun add(favorite: Proverbs) = favoritesSource.saveSingle(favorite.toData())

    override suspend fun getAll(): List<Proverbs> = favoritesSource.getAll().map { favorite -> favorite.toDomain() }

    override suspend fun deleteSingle(favoriteId: Int) = favoritesSource.deleteSingle(favoriteId)

    override suspend fun deleteAll() = favoritesSource.deleteAll()
}