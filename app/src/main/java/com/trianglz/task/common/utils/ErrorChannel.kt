package com.trianglz.task.common.utils

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

object ErrorChannel {
    private val _errorSharedFlow: MutableSharedFlow<String> = MutableSharedFlow()
    val sharedFlow: SharedFlow<String>
        get() = _errorSharedFlow

    fun emitErrors(msg: String?) {
        GlobalScope.launch {
            msg?.let { _errorSharedFlow.emit(it) }
        }
    }
}