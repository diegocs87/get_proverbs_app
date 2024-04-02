package com.example.clean_test.data

import android.content.Context
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.data.repository.ProverbsRepositoryImplementation
import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.domain.usecase.GetProverbsUseCase
import com.example.clean_test.domain.usecase.GetProverbsUseCaseImplementation
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProverbsRepositoryImplementationTest {
    private lateinit var proverbsViewModel:ProverbsViewModel
    private val localRepositoryMock = mockk<ProverbsProvider>(relaxed = true)
    private val remoteRepositoryMock = mockk<ProverbsProvider>(relaxed = true)
    private val networkConnectionVerifierMock = mockk<NetworkConnectionVerifier>(relaxed = true)
    private val proverbsRepository = ProverbsRepositoryImplementation(localRepositoryMock,remoteRepositoryMock,networkConnectionVerifierMock)
    private val getProverbsUseCase = GetProverbsUseCaseImplementation(proverbsRepository)
    private val mockedContext = mockk<Context>()
    val dispatcher = TestCoroutineDispatcher()
    @Before
    fun setUp(){
        Dispatchers.setMain(dispatcher)
        proverbsViewModel = ProverbsViewModel(getProverbsUseCase)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getLocal() {
        coEvery { networkConnectionVerifierMock.verify() } returns true
        runTest {
            proverbsViewModel.update(mockedContext)
        }
    }

    @Test
    fun getRemote() {
        coEvery { networkConnectionVerifierMock.verify() } returns false
        runTest {
            proverbsViewModel.update(mockedContext)
        }
    }
}