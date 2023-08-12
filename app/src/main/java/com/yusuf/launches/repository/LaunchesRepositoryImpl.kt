package com.yusuf.launches.repository

import com.yusuf.launches.api.LaunchesApiService
import com.yusuf.launches.base.BaseRepository
import com.yusuf.launches.models.response.LaunchDataResponse
import com.yusuf.launches.resources.ApiResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor(
    private val launchesApiService: LaunchesApiService,
) : LaunchesRepository, BaseRepository() {

    @ExperimentalCoroutinesApi
    override fun getLaunches(): Flow<ApiResult<LaunchDataResponse>> {
        return onApiCall { launchesApiService.getLaunchers() }
    }
}