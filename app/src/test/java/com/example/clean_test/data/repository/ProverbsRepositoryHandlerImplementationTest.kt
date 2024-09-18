package com.example.clean_test.data.repository

import android.content.Context
import com.example.clean_test.data.repository.remote.RemoteRepositoryDataSource
import com.example.clean_test.data.model.ProverbsDataModel
import com.example.clean_test.data.model.toDomain
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.data.repository.handler.ProverbsRepositoryHandlerImplementation
import com.example.clean_test.data.repository.local.LocalDataSource
import com.example.clean_test.domain.entities.Proverbs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProverbsRepositoryHandlerImplementationTest{
    private lateinit var proverbsRepositoryImplementationSut: ProverbsRepositoryHandlerImplementation
    private val localSourceMock = mockk<LocalDataSource>(relaxed = true)
    private val remoteSourceMock = mockk<RemoteRepositoryDataSource>(relaxed = true)
    private val networkConnectionVerifier = mockk <NetworkConnectionVerifier>(relaxed = true)
    private val contextMock = mockk<Context>(relaxed = true)

    companion object{
        val PROVERBS_DATA_MODEL_STUB_LIST = listOf(ProverbsDataModel("test proverb","DB"))
        val PROVERBS_MODEL_EXPECTED_LIST = listOf(Proverbs("test proverb","DB"))
    }
    @Before
    fun setUp(){
        proverbsRepositoryImplementationSut = ProverbsRepositoryHandlerImplementation(localSourceMock,remoteSourceMock,networkConnectionVerifier)
    }

    @After
    fun tearDown(){
        unmockkAll()
    }

    @Test
    fun `When retrieving proverbs from source, Given a device with internet connection, Then proverbs have to be retrieved and mapped from remote source`() = runBlocking{
        `Given a device with internet connection`()
        `When retrieving proverbs from source`()
        `Then proverbs have to be retrieved and mapped from remote source`()
    }

    @Test
    fun `When retrieving proverbs from source, Given a device with no internet connection, Then proverbs have to be retrieved and mapped from local source`() = runBlocking{
        `Given a device with no internet connection`()
        `When retrieving proverbs from source`()
        `Then proverbs have to be retrieved and mapped from local source`()
    }


    @Test
    fun `When retrieving proverbs from source, Given a retrieved proverbs list with data model structure, Then proverbs have to be mapped into a domain model List`() = runBlocking{
        `Given a retrieved proverbs list with data model structure`()
        val mappedProverbsList = `When retrieving proverbs from source`()
        `Then proverbs have to be mapped into a domain model List`(mappedProverbsList)
    }

    private fun `Given a retrieved proverbs list with data model structure`() {
        coEvery { localSourceMock.getAllProverbs() } returns PROVERBS_DATA_MODEL_STUB_LIST
    }

    private fun `Given a device with no internet connection`(){
        coEvery { networkConnectionVerifier.verify() } returns false
    }

    private fun `Given a device with internet connection`(){
        coEvery { networkConnectionVerifier.verify() } returns true
    }

    private fun `When retrieving proverbs from source`() = runBlocking {
        proverbsRepositoryImplementationSut.retrieveFromSource(contextMock)
    }


    private fun `Then proverbs have to be retrieved and mapped from remote source`(){
        coVerify(exactly = 1) { remoteSourceMock.get(contextMock).map { proverbsList -> proverbsList.toDomain() } }
    }

    private fun `Then proverbs have to be retrieved and mapped from local source`(){
        coVerify(exactly = 1) { localSourceMock.getAllProverbs().map { proverbsList -> proverbsList.toDomain() } }
    }

    private fun `Then proverbs have to be mapped into a domain model List`(mappedProverbsList:List<Proverbs>) {
        assertEquals(mappedProverbsList,PROVERBS_MODEL_EXPECTED_LIST)
    }
}