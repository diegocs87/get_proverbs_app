package com.example.clean_test.data.network

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetAddress
import java.net.UnknownHostException

class NetworkConnectionVerifierImplementation: NetworkConnectionVerifier {
    override suspend fun verify(context:Context):Boolean {
        try {
            val address: InetAddress =
                withContext(Dispatchers.IO) {
                    InetAddress.getByName("www.google.com")
                }

            return !address.equals("")
        } catch (connectionError: UnknownHostException) {
            connectionError.printStackTrace()
        }
        return false
    }
}