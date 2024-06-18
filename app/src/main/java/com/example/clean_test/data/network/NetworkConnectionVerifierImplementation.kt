package com.example.clean_test.data.network

import com.example.clean_test.presentation.di.qualifiers.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.net.InetAddress
import java.net.UnknownHostException
import javax.inject.Inject

class NetworkConnectionVerifierImplementation @Inject constructor(@IODispatcher private val dispatcher: CoroutineDispatcher): NetworkConnectionVerifier {
    private lateinit var address:InetAddress
    companion object {
        var TEST_DOMAIN = "www.google.com"
    }
    override suspend fun verify():Boolean {
        try {
                address = withContext(dispatcher) {
                    InetAddress.getByName(TEST_DOMAIN)
            }
            return !address.equals("")
        } catch (connectionError: UnknownHostException) {
            connectionError.printStackTrace()
        }
        return false
    }
}