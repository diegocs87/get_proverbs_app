package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import com.example.clean_test.data.db.model.ProverbsDbData
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LocalProverbsCreatorTest{
    companion object{
        val proverbListMock = listOf(ProverbsDbData(src = "API", proverb = "proverb1"), ProverbsDbData(src = "DB", proverb = "proverb2"))
        val singleProverbMock = ProverbsDbData(src = "API", proverb = "proverbSingle")
    }
    private val dbDaoMock = mockk<ProverbsDbDao>(relaxed = true)
    private lateinit var localProverbsCreatorSut:LocalProverbsCreator
    @Before
    fun setUp(){
        localProverbsCreatorSut = LocalProverbsCreator(dbDaoMock)
    }

    @After
    fun tearDown(){
        unmockkAll()
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun insertAll(){
        runTest { localProverbsCreatorSut.insertAll(proverbListMock) }
        coVerify { dbDaoMock.insertAllProverbs(proverbListMock) }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun insertSingle(){
        runTest { localProverbsCreatorSut.insertSingle(singleProverbMock) }
        coVerify { dbDaoMock.insertSingleProverb(singleProverbMock) }
    }
}