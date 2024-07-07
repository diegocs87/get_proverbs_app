package com.example.clean_test.data.db.crud

import com.example.clean_test.data.db.dao.ProverbsDbDao
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LocalProverbsReaderTest {

    companion object{
        const val SINGLE_PROVERB_ID = 1
    }

    private val dbDaoMock = mockk<ProverbsDbDao>(relaxed = true)
    private lateinit var localProverbsReaderSut:LocalProverbsReader

    @Before
    fun setUp() {
        localProverbsReaderSut = LocalProverbsReader(dbDaoMock)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getAll() {
        runTest { localProverbsReaderSut.getAll() }
        coVerify { dbDaoMock.getAllProverbs() }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getSingle() {
        runTest { localProverbsReaderSut.getSingle(SINGLE_PROVERB_ID) }
        coVerify { dbDaoMock.getSingleProverb(SINGLE_PROVERB_ID) }
    }
}