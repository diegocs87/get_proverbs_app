package com.example.clean_test.framework_drivers

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.ProverbsDb
import com.example.clean_test.data.repository.local.ProverbsLocalDataSource
import com.example.clean_test.data.db.model.ProverbsDbData
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProverbsDbTest {
//    private lateinit var proverbsDbSut: ProverbsDb
//    private lateinit var proverbsDbDao: ProverbsDbDao
//    private lateinit var proverbsLocalDataSourceSut: ProverbsLocalDataSource
//    private val context = ApplicationProvider.getApplicationContext<Context>()
//    @Before
//    fun setUp(){
//        proverbsDbSut = ProverbsDb.getInstance(context)
//        proverbsLocalDataSourceSut = ProverbsLocalDataSource()
//        proverbsDbDao = proverbsDbSut.proverbsDao()
//    }
//
//    @After
//    fun tearDown(){
//        proverbsDbSut.close()
//    }
//
//    @Test
//    fun test1(){
//        val testList = listOf(ProverbsDbData(proverb = "test proverb", src = "db"))
//        proverbsDbDao.insertAllProverbs(testList)
//        Assert.assertEquals("test proverb", proverbsDbDao.getAllProverbs()[0].proverb)
//    }
//
//    @Test
//    fun test2(){
//        runBlocking { proverbsLocalDataSourceSut.get(context) }
//    }
}