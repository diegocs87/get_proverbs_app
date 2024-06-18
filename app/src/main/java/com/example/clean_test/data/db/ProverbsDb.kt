package com.example.clean_test.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.ProverbsDbData

@Database(entities = [ProverbsDbData::class], version = 1, exportSchema = false)
abstract class ProverbsDb : RoomDatabase() {
    abstract fun proverbsDao(): ProverbsDbDao
}