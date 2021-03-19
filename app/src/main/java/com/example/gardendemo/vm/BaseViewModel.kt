package com.example.gardendemo.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gardendemo.network.ApiException
import com.example.gardendemo.network.ExceptionHandle
import com.example.gardendemo.network.ResponseThrowable
import com.example.gardendemo.network.response.BaseResponse


import kotlinx.coroutines.*

open class BaseViewModel() : ViewModel() {

    private fun launchUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    fun launchAPI(
            block: suspend CoroutineScope.() -> Unit,
            error: suspend CoroutineScope.(Throwable) -> Unit = {},
            complete: suspend CoroutineScope.() -> Unit = {}
    ) {
        launchUI {
            handleException(
                    withContext(Dispatchers.IO) {
                        block
                    },
                    {
                        error(it)
                    },
                    {
                        complete()
                    }
            )
        }
    }

    //各類網路錯誤或系統錯誤處裡
    private suspend fun handleException(
        block: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit,
        complete: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                block()
            } catch (e: Throwable) {
                error(ExceptionHandle.handleException(e))
            } finally {
                complete()
            }
        }
    }

    suspend fun <T> verifyResponse(
        response: BaseResponse<T>,
        success: suspend CoroutineScope.(T) -> Unit
    ) {
        coroutineScope {
/*            if (response.result != null) success(response.result)
            else {
                throw ApiException(9999, "API ERROR")
            }*/
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}