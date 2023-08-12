package com.yusuf.launches.base

import com.fasterxml.jackson.annotation.JsonProperty

data class BaseResponse<T>(
    @JsonProperty("isSucceed")
    val isSucceed: Boolean,
    @JsonProperty("message")
    val message: String,
    @JsonProperty("data")
    val data: T?,
)