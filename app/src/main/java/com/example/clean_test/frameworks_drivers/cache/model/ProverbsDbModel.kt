package com.example.clean_test.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proverbs_table")
data class ProverbsDbModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "proverb") val proverb: String,
    @ColumnInfo(name = "src") val src:String)