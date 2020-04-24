package com.soulesidibe.multiplaform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val applicationDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default
/**
 * Created by soulesidibe on 4/18/20 at 15:35
 * Project name : MultiplatformApp
 */
actual val applicationDispatcherMain: CoroutineDispatcher
    get() = Dispatchers.Main