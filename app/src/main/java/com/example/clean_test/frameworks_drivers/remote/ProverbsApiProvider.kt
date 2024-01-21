package com.example.clean_test.remote

import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.domain.model.Proverbs

class ProverbsApiProvider(): ProverbsProvider {

    private val proverbs = listOf( Proverbs("Dime con quién andas y te diré quién eres.","API"),
        Proverbs("Ojos que no ven, corazón que no siente.","API"),
        Proverbs("Más vale prevenir que lamentar.","API"),
        Proverbs("A quien madruga, Dios le ayuda.","API"),
        Proverbs("A mal tiempo, buena cara.","API"),
        Proverbs("El que mucho quiere, todo lo pierde.","API")
    )

    override fun getProverbs():List<Proverbs> = proverbs
}
