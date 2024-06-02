package com.example.clean_test.data.repository.factory

import android.content.Context
import com.example.clean_test.data.db.ProverbsDb
import com.example.clean_test.data.db.crud.LocalProverbsCreator
import com.example.clean_test.data.db.crud.LocalProverbsDeleter
import com.example.clean_test.data.db.crud.LocalProverbsReader
import com.example.clean_test.data.repository.local.LocalProverbsDataSource
import com.example.clean_test.data.repository.local.ProverbsLocalDataSource

class LocalRepositoryFactoryImpl(val context:Context): LocalRepositoryFactory {
    private val dao = ProverbsDb.getInstance(context).proverbsDao()
    override fun create(): LocalProverbsDataSource = ProverbsLocalDataSource(localProverbsReader = LocalProverbsReader(dao),
        localProverbsCreator = LocalProverbsCreator(dao),
        localProverbsDeleter = LocalProverbsDeleter(dao))
}