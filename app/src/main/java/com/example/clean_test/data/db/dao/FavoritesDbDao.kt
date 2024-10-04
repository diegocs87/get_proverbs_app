package com.example.clean_test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.clean_test.data.db.model.FavoriteDbData

@Dao
interface FavoritesDbDao {
    @Query("SELECT * FROM favorites_table")
    fun getAllFavorites(): List<FavoriteDbData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFavorites(proverbsList: List<FavoriteDbData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleFavorite(proverb: FavoriteDbData): Long

    @Query("SELECT * FROM favorites_table WHERE id = :proverbId")
    fun getSingleFavorite(proverbId: Int): FavoriteDbData?

    @Query("DELETE FROM favorites_table WHERE id = :proverbId")
    fun deleteSingleFavorite(proverbId: Int)

    @Query("DELETE FROM favorites_table")
    fun deleteAllFavorites()
}