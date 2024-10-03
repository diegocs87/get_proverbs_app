package com.example.clean_test.data.repository.local

import com.example.clean_test.data.db.crud.Creator
import com.example.clean_test.data.db.crud.Deleter
import com.example.clean_test.data.db.crud.Reader
import com.example.clean_test.data.db.model.toProverbsDBData
import com.example.clean_test.data.model.ProverbsDataModel
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProverbsLocalDataSourceTest {

    companion object{
        val MOCK_DISPATCHER = Dispatchers.IO
        const val SINGLE_PROVERB_ID_MOCK = 0
        val proverbListMock = listOf(ProverbsDataModel(src = "API", proverb = "proverb1"), ProverbsDataModel(src = "DB", proverb = "proverb2"))
        val singleProverbMock = ProverbsDataModel(src = "API", proverb = "proverbSingle")
    }

    private lateinit var proverbsLocalDataSourceSut: ProverbsLocalDataSource
    private val localProverbsCreator = mockk<Creator>(relaxed = true)
    private val localProverbsReader = mockk<Reader>(relaxed = true)
    private val localProverbsDeleter = mockk <Deleter>(relaxed = true)

    @Before
    fun setUp() {
        proverbsLocalDataSourceSut = ProverbsLocalDataSource(MOCK_DISPATCHER, localProverbsReader, localProverbsCreator, localProverbsDeleter)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getAllProverbs() {
        runTest { proverbsLocalDataSourceSut.getAllProverbs() }
        coVerify { localProverbsReader.getAll() }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getSingleProverb() {
        runTest { proverbsLocalDataSourceSut.getSingleProverb(SINGLE_PROVERB_ID_MOCK) }
        coVerify { localProverbsReader.getSingle(SINGLE_PROVERB_ID_MOCK) }

    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun insertWithPreviousDeletion() {
        runTest { proverbsLocalDataSourceSut.saveAll(proverbListMock, true) }
        coVerify (exactly = 1) { localProverbsDeleter.deleteAllProverbs() }
        coVerify (exactly = 1){ localProverbsCreator.insertAll(proverbListMock.map { it.toProverbsDBData() }) }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun insertWithoutPreviousDeletion() {
        runTest { proverbsLocalDataSourceSut.saveAll(proverbListMock, false) }
        coVerify (exactly = 0) { localProverbsDeleter.deleteAllProverbs() }
        coVerify (exactly = 1){ localProverbsCreator.insertAll(proverbListMock.map { it.toProverbsDBData() }) }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun saveSingle() {
        runTest { proverbsLocalDataSourceSut.saveSingle(singleProverbMock) }
        coVerify { localProverbsCreator.insertSingle(singleProverbMock.toProverbsDBData()) }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun deleteAllProverbs() {
        runTest { proverbsLocalDataSourceSut.deleteAllProverbs() }
        coVerify { localProverbsDeleter.deleteAllProverbs() }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun deleteSingleProverb() {
        runTest { proverbsLocalDataSourceSut.deleteSingleProverb(SINGLE_PROVERB_ID_MOCK) }
        coVerify { localProverbsDeleter.deleteSingleProverb(SINGLE_PROVERB_ID_MOCK) }
    }
}