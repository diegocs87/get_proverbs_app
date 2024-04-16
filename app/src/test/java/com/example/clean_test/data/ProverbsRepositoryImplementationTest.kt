package com.example.clean_test.data

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.data.repository.ProverbsRepositoryImplementation
import com.example.clean_test.data.repository.factory.LocalRepositoryFactory
import com.example.clean_test.data.repository.factory.RemoteRepositoryFactory
import com.example.clean_test.domain.usecase.GetProverbsUseCaseImplementation
import com.example.clean_test.presentation.di.UseCaseCreator
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
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
class ProverbsRepositoryImplementationTest {
    private lateinit var proverbsViewModel:ProverbsViewModel
    private val localRepository = LocalRepositoryFactory().create()
    private val remoteRepository= RemoteRepositoryFactory().create()
    private val networkConnectionVerifierMock = mockk<NetworkConnectionVerifier>(relaxed = true)
    private val proverbsRepository = ProverbsRepositoryImplementation(localRepository,remoteRepository,networkConnectionVerifierMock)
    private val getProverbsUseCase = GetProverbsUseCaseImplementation(proverbsRepository)
    private val proverbsUseCaseFromFactory = UseCaseCreator().getProverbsUseCase()
    private val mockedContext = mockk<Context>()
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp(){
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown(){
        unmockkAll()
        Dispatchers.resetMain()
    }

    @Test
    fun getProverb(){
        proverbsViewModel = ProverbsViewModel(proverbsUseCaseFromFactory)
        proverbsViewModel.update(mockedContext)
    }

    @Test
    fun getRemote() {
        proverbsViewModel = ProverbsViewModel(getProverbsUseCase)
        coEvery { networkConnectionVerifierMock.verify() } returns false
        runTest {
            proverbsViewModel.update(mockedContext)
        }
    }
}