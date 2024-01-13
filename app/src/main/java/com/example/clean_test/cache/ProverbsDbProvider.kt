package com.example.clean_test.cache

import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.domain.model.Proverbs

class ProverbsDbProvider(): ProverbsProvider {
    private val proverbs = listOf(
        Proverbs("Más vale tarde que nunca.","DB"),
        Proverbs("No dejes para mañana lo que puedas hacer hoy.","DB"),
        Proverbs("El que mucho abarca, poco aprieta","DB"),
        Proverbs("Camarón que se duerme se lo lleva la corriente","DB"),
        Proverbs("En boca cerrada no entran moscas.","DB"),
        Proverbs("No hay mal que por bien no venga.","DB")
    )

    override fun getProverbs():List<Proverbs> = proverbs
}
