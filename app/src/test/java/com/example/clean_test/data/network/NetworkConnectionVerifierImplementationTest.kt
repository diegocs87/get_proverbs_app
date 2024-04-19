package com.example.clean_test.data.network

import io.mockk.coVerify
import io.mockk.unmockkAll
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.net.InetAddress
import java.net.UnknownHostException

class NetworkConnectionVerifierImplementationTest {

    private lateinit var networkConnectionVerifierSut: NetworkConnectionVerifier

    @Before
    fun setUp(){
        networkConnectionVerifierSut = NetworkConnectionVerifierImplementation()
    }

    @After
    fun tearDown(){
        unmockkAll()
    }

    @Test
    fun `When asking if internet connection is available, Given a valid network connection, Then the validation result should be true`(){
        runBlocking {
            val result = networkConnectionVerifierSut.verify()
            assertTrue(result)
        }
    }

    @Test(expected = UnknownHostException::class)
    fun verify_with_host_exception() {
        NetworkConnectionVerifierImplementation.TEST_DOMAIN = "test_fake_domain"
        runBlocking {
            val result = networkConnectionVerifierSut.verify()

            assertFalse(result)
        }
        coVerify {
            withContext(Dispatchers.IO) {
                InetAddress.getByName(NetworkConnectionVerifierImplementation.TEST_DOMAIN)
            }
        }
    }
}