package com.soulesidibe.multiplaform

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.http.HttpStatusCode

/**
 * Created by soulesidibe on 4/18/20 at 19:22
 * Project name : MultiplatformApp
 */

internal interface NumberTriviaClient {
    suspend fun getRandomNumber(): String
}

class NumberTriviaClientImpl(private val httpclient: HttpClient) : NumberTriviaClient {
    override suspend fun getRandomNumber(): String {
        val url = "http://numbersapi.com/random"
        val response = httpclient.get<HttpResponse>(url)
        return if (response.status == HttpStatusCode.OK) {
            response.readText()
        } else {
            ""
        }
    }

}