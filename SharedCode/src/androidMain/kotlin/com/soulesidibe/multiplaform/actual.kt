package com.soulesidibe.multiplaform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val applicationDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default
/**
 * Created by soulesidibe on 4/18/20 at 15:35
 * Project name : MultiplatformApp
 */
internal actual val applicationDispatcherMain: CoroutineDispatcher
    get() = Dispatchers.Main