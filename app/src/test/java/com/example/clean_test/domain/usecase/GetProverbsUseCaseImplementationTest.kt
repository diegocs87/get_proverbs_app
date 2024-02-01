package com.example.clean_test.domain.usecase

import com.example.clean_test.data.network.NetworkConnectionVerifier
import com.example.clean_test.domain.ProverbsRepository
import com.example.clean_test.domain.model.Proverbs
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetProverbsUseCaseImplementationTest {
    private lateinit var networkConnectionVerifier: NetworkConnectionVerifier
    private lateinit var proverbsRepository: ProverbsRepository
    private lateinit var getProverbsUseCaseImplementation:GetProverbsUseCaseImplementation
    private lateinit var localProverbsList:List<Proverbs>
    private lateinit var remoteProverbsList:List<Proverbs>
    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        localProverbsList = listOf(Proverbs("proverb test 1","db"), Proverbs("proverb test 2","db"))
        remoteProverbsList = listOf(Proverbs("proverb test 3","API"), Proverbs("proverb test 4","API"))
        proverbsRepository = mockk()
        networkConnectionVerifier = mockk()
        getProverbsUseCaseImplementation = GetProverbsUseCaseImplementation(proverbsRepository,networkConnectionVerifier)
        every { proverbsRepository.getLocal() } returns localProverbsList
        every { proverbsRepository.getRemote() } returns remoteProverbsList
    }

    @After
    fun after(){
        unmockkAll()
    }
    @Test
    fun `When asking for proverbs,Given no internet connection,Then a list of proverbs has to be retrieved from local source`() {
        `Given no internet connection`()
        val expectedList = `When getting a proverb`()
        `Then a list of proverbs has to be retrieved from remote source`(expectedList,localProverbsList)
    }

    @Test
    fun `When asking for proverbs,Given internet connection,Then a list of proverbs has to be retrieved from remote source`() {
        `Given internet connection`()
        val expectedList = `When getting a proverb`()
        `Then a list of proverbs has to be retrieved from remote source`(expectedList,remoteProverbsList)
    }

    private fun `When getting a proverb`():List<Proverbs> = getProverbsUseCaseImplementation.get()


    private fun `Given internet connection`() = every { networkConnectionVerifier.verify() } returns true

    private fun `Given no internet connection`() = every { networkConnectionVerifier.verify() } returns false


    private fun `Then a list of proverbs has to be retrieved from remote source`(expectedList:List<Proverbs>, retrievedList:List<Proverbs>)
    = assert(expectedList == retrievedList)

}