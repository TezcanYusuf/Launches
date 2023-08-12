package com.yusuf.launches.repository

import com.yusuf.launches.models.response.LaunchDataResponse
import com.yusuf.launches.resources.ApiResult
import kotlinx.coroutines.flow.*

interface LaunchesRepository {

    fun getLaunches(): Flow<ApiResult<LaunchDataResponse>>

}