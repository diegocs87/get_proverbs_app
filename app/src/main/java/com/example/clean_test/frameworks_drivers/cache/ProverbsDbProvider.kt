package com.example.clean_test.frameworks_drivers.cache

import android.content.Context
import com.example.clean_test.data.ProverbsProvider
import com.example.clean_test.data.model.ProverbsDataModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProverbsDbProvider( private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO): ProverbsProvider {
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
