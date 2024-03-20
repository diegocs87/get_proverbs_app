package com.example.clean_test.frameworks_drivers.remote

import android.content.Context
import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.data.model.ProverbsDataModel

class ProverbsApiProvider(): ProverbsProvider {

    private val proverbs = listOf( ProverbsDataModel("Dime con quién andas y te diré quién eres.","API"),
        ProverbsDataModel("Ojos que no ven, corazón que no siente.","API"),
        ProverbsDataModel("Más vale prevenir que lamentar.","API"),
        ProverbsDataModel("A quien madruga, Dios le ayuda.","API"),
        ProverbsDataModel("A mal tiempo, buena cara.","API"),
        ProverbsDataModel("El que mucho quiere, todo lo pierde.","API")
    )

    override suspend fun get(context: Context):List<ProverbsDataModel> = proverbs
}
