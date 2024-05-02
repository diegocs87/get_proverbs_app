package com.example.clean_test.data

import android.content.Context
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.data.repository.ProverbsRepositoryImplementation
import com.example.clean_test.data.repository.factory.LocalRepositoryFactory
import com.example.clean_test.data.repository.factory.RemoteRepositoryFactory
import com.example.clean_test.domain.services.GetProverbsUseCaseImplementation
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProverbsRepositoryIntegrationTest {
    private lateinit var proverbsViewModel:ProverbsViewModel
    private val localRepository = LocalRepositoryFactory().create()
    private val remoteRepository = RemoteRepositoryFactory().create()
    private val networkConnectionVerifierMock = mockk<NetworkConnectionVerifier>(relaxed = true)
    private val proverbsRepository = ProverbsRepositoryImplementation(localRepository,remoteRepository,networkConnectionVerifierMock)
    private val getProverbsUseCase = GetProverbsUseCaseImplementation(proverbsRepository)
    private val mockedContext = mockk<Context>()
    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = UnconfinedTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp(){
        Dispatchers.setMain(dispatcher)
        proverbsViewModel = ProverbsViewModel(getProverbsUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `When retrieve proverbs, Given internet connection, Then proverbs should be retrieved from remote source`() {
        `Given internet connection`()
        `When retrieve proverbs`()
    }

    @Test
    fun `When retrieve proverbs, Given no internet connection, Then proverbs should be retrieved from local source`() {
        `Given no internet connection`()
        `When retrieve proverbs`()
    }

    private fun `Given no internet connection`() {
        coEvery { networkConnectionVerifierMock.verify() } returns false
    }

    private fun `Given internet connection`(){
        coEvery { networkConnectionVerifierMock.verify() } returns true
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun `When retrieve proverbs`(){
        runTest {
            proverbsViewModel.update(mockedContext)
        }
    }
}