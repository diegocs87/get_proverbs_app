package com.example.clean_test.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetAddress
import java.net.UnknownHostException

class NetworkConnectionVerifierImplementation: NetworkConnectionVerifier {
    companion object {
        private const val TEST_DOMAIN = "www.google.com"
    }
    override suspend fun verify():Boolean {
        try {
            val address: InetAddress = withContext(Dispatchers.IO) {
                    InetAddress.getByName(TEST_DOMAIN)
            }
            return !address.equals("")
        } catch (connectionError: UnknownHostException) {
            connectionError.printStackTrace()
        }
        return false
    }
}