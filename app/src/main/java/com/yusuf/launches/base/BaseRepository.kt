package com.yusuf.launches.base

import com.yusuf.launches.BuildConfig
import com.yusuf.launches.resources.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    fun <T : Any> onApiCall(call: suspend () -> T): Flow<ApiResult<T>> =
        flow {
            emit(ApiResult.Loading)
            val result = call.invoke()
            emit(ApiResult.Success(result))
        }.catch { error ->
            if (BuildConfig.DEBUG) {
                error.printStackTrace()
            }
            emit(ApiResult.Error(error))
        }.flowOn(Dispatchers.IO)
}
