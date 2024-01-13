package com.example.clean_test.domain

import com.example.clean_test.domain.model.Proverbs

interface ProverbsRepository {
    fun getProverbs():List<Proverbs>  // no debería retornar datos del modelo de dominio, debería retornar del modelo de data
}