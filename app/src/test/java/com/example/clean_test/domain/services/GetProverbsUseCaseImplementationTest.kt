package com.example.clean_test.domain.services

import android.content.Context
import com.example.clean_test.domain.repository.ProverbsRepositoryHandler
import com.example.clean_test.domain.usecases.GetProverbsUseCaseImplementation
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetProverbsUseCaseImplementationTest {

    private lateinit var getProverbsUseCaseImplementationSut: GetProverbsUseCaseImplementation
    private val repositoryMock = mockk<ProverbsRepositoryHandler>(relaxed = true)
    private val contextMock = mockk<Context>(relaxed = true)

    @Before
    fun setUp() {

    }

    @After
    fun after() {
        unmockkAll()
    }

    @Test
    fun `When getting proverbs use case, Given a valid repository, Then use case should retrieve proverbs from the given repository`(){
        `When getting proverbs use case, Given a valid repository`()
        `Then use case should retrieve proverbs from the given repository`()
    }

    private fun `When getting proverbs use case, Given a valid repository`(){
        getProverbsUseCaseImplementationSut = GetProverbsUseCaseImplementation(repositoryMock)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun `Then use case should retrieve proverbs from the given repository`(){
        runTest { getProverbsUseCaseImplementationSut.get(contextMock) }
        coVerify(exactly = 1) { repositoryMock.retrieveFromSource(any()) }
    }
}
