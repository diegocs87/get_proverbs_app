package com.example.clean_test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.clean_test.data.db.model.ProverbsDbData

@Dao
interface ProverbsDbDao{
    @Query("SELECT * FROM proverbs_table")
    fun getAllProverbs():List<ProverbsDbData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllProverbs(proverbsList: List<ProverbsDbData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleProverb(proverbsDbModel: ProverbsDbData): Long

    @Query("SELECT * FROM proverbs_table WHERE id = :proverbId")
    fun getSingleProverb(proverbId: Int): ProverbsDbData?

    @Query("DELETE FROM proverbs_table")
    fun deleteAllProverbs()
}