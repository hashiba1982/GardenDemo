package com.example.gardendemo.network.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<out T>(
    @SerializedName("result")
    val result: T?,
)