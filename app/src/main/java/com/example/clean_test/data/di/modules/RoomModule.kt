package com.example.clean_test.data.di.modules

import android.content.Context
import androidx.room.Room
import com.example.clean_test.data.db.ProverbsDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DB_NAME = "ProverbsDb"

    @Singleton
    @Provides
    fun roomDataBaseProvider(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext, ProverbsDb::class.java, DB_NAME
    ).build()

    @Singleton
    @Provides
    fun roomDbDaoProvider(db:ProverbsDb) = db.proverbsDao()
}