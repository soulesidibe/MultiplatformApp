package com.soulesidibe.multiplaform

import kotlinx.coroutines.*
import platform.darwin.*
import kotlin.coroutines.CoroutineContext

internal actual val applicationDispatcher: CoroutineDispatcher
    get() = NsQueueDispatcherIO(dispatch_get_main_queue())

internal actual val applicationDispatcherMain: CoroutineDispatcher
    get() = NsQueueDispatcher()

@UseExperimental(InternalCoroutinesApi::class)
internal class NsQueueDispatcher(
) : CoroutineDispatcher(), Delay {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            block.run()
        }
    }

    override fun scheduleResumeAfterDelay(
        timeMillis: Long,
        continuation: CancellableContinuation<Unit>
    ) {
        val queue = dispatch_get_main_queue()

        val time = dispatch_time(DISPATCH_TIME_NOW, (timeMillis * NSEC_PER_MSEC.toLong()))
        dispatch_after(time, queue) {
            with(continuation) {
                resumeUndispatched(Unit)
            }
        }
    }
}

@UseExperimental(InternalCoroutinesApi::class)
internal class NsQueueDispatcherIO(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher(), Delay {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }

    override fun scheduleResumeAfterDelay(
        timeMillis: Long,
        continuation: CancellableContinuation<Unit>
    ) {
        val queue = dispatch_get_main_queue()

        val time = dispatch_time(DISPATCH_TIME_NOW, (timeMillis * NSEC_PER_MSEC.toLong()))
        dispatch_after(time, queue) {
            with(continuation) {
                resumeUndispatched(Unit)
            }
        }
    }
}