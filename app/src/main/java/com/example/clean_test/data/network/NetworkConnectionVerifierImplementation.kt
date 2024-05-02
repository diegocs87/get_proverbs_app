package com.example.clean_test.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetAddress
import java.net.UnknownHostException

class NetworkConnectionVerifierImplementation: NetworkConnectionVerifier {
    private lateinit var address:InetAddress
    companion object {
        var TEST_DOMAIN = "www.google.com"
    }
    override suspend fun verify():Boolean {
        try {
                address = withContext(Dispatchers.IO) {
                    InetAddress.getByName(TEST_DOMAIN)
            }
            return !address.equals("")
        } catch (connectionError: UnknownHostException) {
            connectionError.printStackTrace()
        }
        return false
    }
}