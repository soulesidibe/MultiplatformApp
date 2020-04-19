package com.soulesidibe.multiplaform

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by soulesidibe on 4/18/20 at 15:35
 * Project name : MultiplatformApp
 */

internal expect val applicationDispatcherMain: CoroutineDispatcher
internal expect val applicationDispatcher: CoroutineDispatcher

fun getRandomNumber(response: (String) -> Unit) {
    val client = NumberTriviaClientImpl(HttpClient())

    GlobalScope.launch(applicationDispatcherMain) {
        val text = withContext(applicationDispatcher) {
            client.getRandomNumber()
        }
        response.invoke(text)
    }
}
