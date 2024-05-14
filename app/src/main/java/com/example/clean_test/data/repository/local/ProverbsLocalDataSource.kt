package com.example.clean_test.data.repository.local

import android.content.Context
import com.example.clean_test.data.ProverbsDataSource
import com.example.clean_test.data.db.ProverbsDb
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.data.db.model.toDB
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProverbsLocalDataSource(private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO): ProverbsDataSource {
    private val proverbs = listOf(
        ProverbsDataModel("Más vale tarde que nunca.","DB"),
        ProverbsDataModel("No dejes para mañana lo que puedas hacer hoy.","DB"),
        ProverbsDataModel("El que mucho abarca, poco aprieta","DB"),
        ProverbsDataModel("Camarón que se duerme se lo lleva la corriente","DB"),
        ProverbsDataModel("En boca cerrada no entran moscas.","DB"),
        ProverbsDataModel("No hay mal que por bien no venga.","DB")
    )

    override suspend fun get(context: Context):List<ProverbsDataModel>{
        withContext(coroutineDispatcher){
            val dao = ProverbsDb.getInstance(context).proverbsDao()
            dao.insertAllProverbs(proverbs.map { it.toDB() })
        }
        return proverbs
    }
}
