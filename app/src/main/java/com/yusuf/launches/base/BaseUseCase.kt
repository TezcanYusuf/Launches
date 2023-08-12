package com.yusuf.launches.base

import com.yusuf.launches.resources.Resource
import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<Request, Response> {
    operator fun invoke(params: Request): Flow<Resource<Response>> = execute(params)

    protected abstract fun execute(params: Request): Flow<Resource<Response>>
}

object NoParams