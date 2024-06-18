package com.example.clean_test.data.di.modules

import com.example.clean_test.data.db.crud.LocalProverbsReader
import com.example.clean_test.data.db.crud.Reader
import com.example.clean_test.data.di.qualifiers.GetLocalProverbsReaderImplementationQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LocalProverbsReaderModule {
    @Binds
    @GetLocalProverbsReaderImplementationQualifier
    abstract fun bindGetLocalProverbsReaderImplementation(localProverbsReader: LocalProverbsReader): Reader
}