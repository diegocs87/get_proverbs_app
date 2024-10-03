package com.example.clean_test.data.repository.local

import com.example.clean_test.data.db.crud.Creator
import com.example.clean_test.data.db.crud.Deleter
import com.example.clean_test.data.db.crud.Reader
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsCreatorImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDeleterImplementationQualifier
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsReaderImplementationQualifier
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.presentation.di.qualifiers.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProverbsLocalDataSource @Inject constructor(@IODispatcher private val coroutineDispatcher: CoroutineDispatcher,
                                                  @GetLocalProverbsReaderImplementationQualifier private val localProverbsReader:Reader,
                                                  @GetLocalProverbsCreatorImplementationQualifier private val localProverbsCreator:Creator,
                                                  @GetLocalProverbsDeleterImplementationQualifier private val localProverbsDeleter: Deleter): LocalDataSource {

    override suspend fun getAll(): List<ProverbsDataModel> {
        return withContext(coroutineDispatcher){
           localProverbsReader.getAll()
        }
    }

    override suspend fun getSingle(proverbId: Int): ProverbsDataModel? {
        return withContext(coroutineDispatcher){
            localProverbsReader.getSingle(proverbId)
        }
    }

    override suspend fun saveAll(proverbsList: List<ProverbsDataModel>, deleteBefore:Boolean) {
        withContext(coroutineDispatcher){
            if(deleteBefore){
                localProverbsDeleter.deleteAllProverbs()
            }
            localProverbsCreator.insertAll(proverbsList)
        }
    }

    override suspend fun saveSingle(proverb: ProverbsDataModel) {
        withContext(coroutineDispatcher){
            localProverbsCreator.insertSingle(proverb)
        }
    }

    override suspend fun deleteAll() {
        localProverbsDeleter.deleteAllProverbs()
    }

    override suspend fun deleteSingle(proverbId: Int) {
        localProverbsDeleter.deleteSingleProverb(proverbId)
    }
}
