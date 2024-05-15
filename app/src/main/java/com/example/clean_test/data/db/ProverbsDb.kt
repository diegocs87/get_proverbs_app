package com.example.clean_test.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.ProverbsDbData

@Database(entities = [ProverbsDbData::class], version = 1, exportSchema = false)
abstract class ProverbsDb : RoomDatabase() {
    abstract fun proverbsDao(): ProverbsDbDao

    companion object{
        private const val DB_NAME = "ProverbsDb"
        @Volatile
        private var dbInstance: ProverbsDb? = null

        fun getInstance(context: Context): ProverbsDb {
            dbInstance?.let { return it }
            synchronized(this){
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    ProverbsDb::class.java,
                    DB_NAME
                ).build()
                dbInstance = newInstance
                return newInstance
            }
        }
    }
}