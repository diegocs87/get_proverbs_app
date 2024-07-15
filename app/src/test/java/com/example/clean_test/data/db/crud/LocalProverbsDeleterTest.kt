package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
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
class LocalProverbsDeleterTest {

    companion object{
        const val SINGLE_PROVERB_ID_MOCK = 0
    }
    private val dbDaoMock = mockk<ProverbsDbDao>(relaxed = true)
    private lateinit var localProverbsDeleterSut:LocalProverbsDeleter
    @Before
    fun setUp(){
        localProverbsDeleterSut = LocalProverbsDeleter(dbDaoMock)
    }

    @After
    fun tearDown(){
        unmockkAll()
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun deleteAllProverbs() {
        runTest { localProverbsDeleterSut.deleteAllProverbs() }
        coVerify { dbDaoMock.deleteAllProverbs() }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun deleteSingleProverb() {
        runTest { localProverbsDeleterSut.deleteSingleProverb(SINGLE_PROVERB_ID_MOCK) }
        coVerify { dbDaoMock.deleteSingleProverb(SINGLE_PROVERB_ID_MOCK) }
    }
}