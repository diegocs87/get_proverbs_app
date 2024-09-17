package com.example.clean_test.domain.repository

interface FavoritesRepositoryHandler {
    fun add()
    fun getAll()
    fun deleteSingle()
    fun deleteAll()
}