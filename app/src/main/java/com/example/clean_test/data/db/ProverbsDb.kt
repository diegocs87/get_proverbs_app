package com.example.clean_test.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clean_test.data.db.dao.FavoritesDbDao
import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.FavoriteDbData
import com.example.clean_test.data.db.model.ProverbsDbData

@Database(entities = [ProverbsDbData::class, FavoriteDbData::class],  version = 2, exportSchema = false)
abstract class ProverbsDb : RoomDatabase() {
    abstract fun proverbsDao(): ProverbsDbDao
    abstract fun favoritesDao(): FavoritesDbDao
}