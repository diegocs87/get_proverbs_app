package com.example.clean_test.frameworks_drivers.cache.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.clean_test.frameworks_drivers.cache.model.ProverbsDbModel

@Dao
interface ProverbsDbDao{
    @Query("SELECT * FROM proverbs_table")
    fun getAllProverbs():List<ProverbsDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllProverbs(proverbsList: List<ProverbsDbModel>)

    @Query("DELETE FROM proverbs_table")
    fun deleteAllProverbs()
}