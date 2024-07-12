package com.example.clean_test.data.repository.remote

import android.content.Context
import com.example.clean_test.data.api.model.ProverbsApiResponse
import com.example.clean_test.data.api.model.toDataModel
import com.example.clean_test.data.api.service.ProverbsAPIService
import com.example.clean_test.data.model.ProverbsDataModel
import io.mockk.coEvery
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
import retrofit2.Response

@RunWith(JUnit4::class)
class ProverbsRemoteDataSourceTest {

    companion object{
        val IODispatcher = Dispatchers.IO
        val expectedProverbs = listOf(
            ProverbsApiResponse(proverb = "Proverb 1", src = "API"),
            ProverbsApiResponse(proverb = "Proverb 2", src = "API")
        )
    }

    private lateinit var proverbsRemoteDataSourceSut:ProverbsRemoteDataSource
    private val apiService = mockk<ProverbsAPIService>(relaxed = true)
    private val contextMock = mockk<Context>(relaxed = true)

    @Before
    fun setUp() {
        proverbsRemoteDataSourceSut = ProverbsRemoteDataSource(IODispatcher,apiService)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When retrieving proverbs from remote source, Given a successful api response, Then api should return a proverbs list`() = runTest {
        `Given a successful api response`()
        val actualProverbs = `When retrieving proverbs from remote source`()
        `Then api should return a proverbs list`(actualProverbs)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When retrieving proverbs from remote source, Given a null api response, Then api should return empty list`() = runTest {
        // Given
        `Given a null api response`()

        // When
        val actualProverbs = `When retrieving proverbs from remote source`()

        // Then
        `Then api should return empty list`(actualProverbs)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When retrieving proverbs from remote source, Given a not successful api response, Then api should return empty list`() = runTest {
        // Given
        `Given a not successful api response`()

        // When
        val actualProverbs = `When retrieving proverbs from remote source`()

        // Then
        `Then api should return empty list`(actualProverbs)
    }

    private fun `Given a successful api response`() {
        coEvery { apiService.getProverbsFromApi() } returns Response.success(expectedProverbs)
    }

    private fun `Given a null api response`() {
        coEvery { apiService.getProverbsFromApi() } returns Response.success(null)
    }

    private fun `Given a not successful api response`() {
        coEvery { apiService.getProverbsFromApi() } returns Response.error(
            404,
            mockk(relaxed = true)
        )
    }

    private suspend fun `When retrieving proverbs from remote source`() = proverbsRemoteDataSourceSut.get(contextMock)

    private fun `Then api should return empty list`(actualProverbs: List<ProverbsDataModel>) {
        assertEquals(emptyList<ProverbsDataModel>(), actualProverbs)
    }

    private fun `Then api should return a proverbs list`(actualProverbs: List<ProverbsDataModel>) {
        assertEquals(actualProverbs, expectedProverbs.map { proverb -> proverb.toDataModel() })
    }
}