package com.example.clean_test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.clean_test.data.db.model.ProverbsDbData

@Dao
interface FavoritesDbDao {
    @Query("SELECT * FROM favorites_table")
    fun getAllFavorites(): List<ProverbsDbData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFavorites(proverbsList: List<ProverbsDbData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleFavorite(proverb: ProverbsDbData): Long

    @Query("SELECT * FROM favorites_table WHERE id = :proverbId")
    fun getSingleFavorite(proverbId: Int): ProverbsDbData?

    @Query("DELETE FROM favorites_table WHERE id = :proverbId")
    fun deleteSingleFavorite(proverbId: Int)

    @Query("DELETE FROM favorites_table")
    fun deleteAllFavorites()

}