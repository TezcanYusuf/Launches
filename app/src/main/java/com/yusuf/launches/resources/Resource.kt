package com.yusuf.launches.resources

sealed class Resource<out T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error(val exception: Throwable) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

inline fun <T, R> ApiResult<T>.map(transform: (T) -> R): Resource<R> {
    return when (this) {
        is ApiResult.Success -> Resource.Success(transform(data))
        is ApiResult.Error -> Resource.Error(exception)
        is ApiResult.Loading -> Resource.Loading
    }
}