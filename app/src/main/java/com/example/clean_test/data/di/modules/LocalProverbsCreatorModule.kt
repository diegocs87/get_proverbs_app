package com.example.clean_test.data.di.modules

import com.example.clean_test.data.db.crud.Creator
import com.example.clean_test.data.db.crud.LocalProverbsCreator
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsCreatorImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalProverbsCreatorModule {

    @Binds
    @GetLocalProverbsCreatorImplementationQualifier
    abstract fun bindGetLocalProverbsCreatorImplementation(localProverbsCreator: LocalProverbsCreator): Creator
}