package com.yusuf.launches.api

import com.yusuf.launches.models.response.LaunchDataResponse
import retrofit2.http.GET

interface LaunchesApiService {

    @GET("/v2/launches")
    suspend fun getLaunchers(
    ): LaunchDataResponse
}
