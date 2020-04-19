package com.soulesidibe.multiplaform

import io.ktor.client.HttpClient
import io.ktor.client.request.get

/**
 * Created by soulesidibe on 4/18/20 at 19:22
 * Project name : MultiplatformApp
 */

internal interface NumberTriviaClient {
    suspend fun getRandomNumber() : String
}

class NumberTriviaClientImpl(private val httpclient: HttpClient): NumberTriviaClient {
    override suspend fun getRandomNumber(): String {
        val url = "http://numbersapi.com/random"
        return httpclient.get(url)
    }

}