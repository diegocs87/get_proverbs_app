package com.example.clean_test.data.repository.local

import com.example.clean_test.data.db.crud.Creator
import com.example.clean_test.data.db.crud.Deleter
import com.example.clean_test.data.db.crud.Reader
import com.example.clean_test.data.db.model.toDB
import com.example.clean_test.data.db.model.toDataModel
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

    override suspend fun getAll(): List<ProverbsDataModel> =
        localFavoritesReader.getAll().map { proverbFromDb -> proverbFromDb.toDataModel() }

    override suspend fun getSingle(proverbId: Int): ProverbsDataModel? =
        localFavoritesReader.getSingle(proverbId)?.toDataModel()

    override suspend fun saveAll(proverbsList: List<ProverbsDataModel>, deleteBefore: Boolean) {
        val proverbListDbModel = proverbsList.map { currentProverb -> currentProverb.toDB() }
        localFavoritesCreator.insertAll(proverbListDbModel)
    }

    override suspend fun saveSingle(proverb: ProverbsDataModel) =
        localFavoritesCreator.insertSingle(proverb.toDB())


    override suspend fun deleteAll() = localFavoritesDeleter.deleteAllProverbs()

    override suspend fun deleteSingle(proverbId: Int) =
        localFavoritesDeleter.deleteSingleProverb(proverbId)
}