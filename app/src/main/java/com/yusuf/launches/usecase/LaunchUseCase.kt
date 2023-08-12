package com.yusuf.launches.usecase

import com.yusuf.launches.base.BaseUseCase
import com.yusuf.launches.mapper.LaunchMapper
import com.yusuf.launches.repository.LaunchesRepository
import com.yusuf.launches.resources.Resource
import com.yusuf.launches.resources.map
import com.yusuf.launches.usecase.ui.LaunchConfigUi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LaunchUseCase @Inject constructor(
    private val launchesRepository: LaunchesRepository,
    private val launchMapper: LaunchMapper
) : BaseUseCase<Any, LaunchConfigUi>() {

    override fun execute(params: Any): Flow<Resource<LaunchConfigUi>> {
        return launchesRepository.getLaunches().map {
            it.map { response ->
                launchMapper.toLaunches(response)
            }
        }
    }
}