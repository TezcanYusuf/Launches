package com.yusuf.launches.resources

sealed class ApiResult<out T> {
    class Success<T>(val data: T) : ApiResult<T>()
    class Error(val exception: Throwable) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}