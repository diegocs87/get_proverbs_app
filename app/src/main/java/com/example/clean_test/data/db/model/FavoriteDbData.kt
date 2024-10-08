package com.example.clean_test.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favorites_table")
data class FavoriteDbData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "proverb") val proverb: String,
    @ColumnInfo(name = "src") val src: String
)
