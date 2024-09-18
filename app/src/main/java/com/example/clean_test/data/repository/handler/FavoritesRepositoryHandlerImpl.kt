package com.example.clean_test.data.repository.handler

import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDataSourceImplementationQualifier
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.data.repository.local.LocalDataSource
import com.example.clean_test.domain.repository.FavoritesRepositoryHandler
import javax.inject.Inject

class FavoritesRepositoryHandlerImpl @Inject constructor(@GetLocalProverbsDataSourceImplementationQualifier private val favoritesSource: LocalDataSource): FavoritesRepositoryHandler {

    override suspend fun add(favorite:ProverbsDataModel) = favoritesSource.saveSingle(favorite)

    override suspend fun getAll():List<ProverbsDataModel> = favoritesSource.getAll()

    override suspend fun deleteSingle(favoriteId: Int) = favoritesSource.deleteSingle(favoriteId)

    override suspend fun deleteAll() = favoritesSource.deleteAll()


}