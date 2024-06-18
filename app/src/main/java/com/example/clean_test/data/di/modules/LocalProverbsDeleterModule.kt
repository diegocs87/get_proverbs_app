package com.example.clean_test.data.di.modules

import com.example.clean_test.data.db.crud.Deleter
import com.example.clean_test.data.db.crud.LocalProverbsDeleter
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsDeleterImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalProverbsDeleterModule {
    @Binds
    @GetLocalProverbsDeleterImplementationQualifier
    abstract fun bindGetLocalProverbsDeleterImplementation(localProverbsDeleter: LocalProverbsDeleter): Deleter
}