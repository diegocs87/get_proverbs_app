package com.example.clean_test.data.repository.local

import com.example.clean_test.data.db.crud.Creator
import com.example.clean_test.data.db.crud.Deleter
import com.example.clean_test.data.db.crud.Reader
import com.example.clean_test.data.di.qualifiers.GetLocalFavoritesCreatorImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetLocalFavoritesDeleterImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetLocalFavoritesReaderImplementationQualifier
import com.example.clean_test.data.model.ProverbsDataModel
import javax.inject.Inject

class FavoritesLocalDataSource @Inject constructor(
    @GetLocalFavoritesReaderImplementationQualifier private val localFavoritesReader: Reader,
    @GetLocalFavoritesCreatorImplementationQualifier private val localFavoritesCreator: Creator,
    @GetLocalFavoritesDeleterImplementationQualifier private val localFavoritesDeleter: Deleter
) : LocalDataSource {

    override suspend fun getAll(): List<ProverbsDataModel> = localFavoritesReader.getAll()

    override suspend fun getSingle(proverbId: Int): ProverbsDataModel? = localFavoritesReader.getSingle(proverbId)

    override suspend fun saveAll(proverbsList: List<ProverbsDataModel>, deleteBefore: Boolean) = localFavoritesCreator.insertAll(proverbsList)


    override suspend fun saveSingle(proverb: ProverbsDataModel) = localFavoritesCreator.insertSingle(proverb)


    override suspend fun deleteAll() = localFavoritesDeleter.deleteAllProverbs()

    override suspend fun deleteSingle(proverb: ProverbsDataModel) =
        localFavoritesDeleter.deleteSingleProverb(proverb)
}