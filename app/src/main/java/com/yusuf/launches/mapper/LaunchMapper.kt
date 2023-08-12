package com.yusuf.launches.mapper

import com.yusuf.launches.models.response.LaunchDataResponse
import com.yusuf.launches.models.response.LaunchDataResponseItem
import com.yusuf.launches.usecase.ui.LaunchConfigUi
import com.yusuf.launches.usecase.ui.LaunchListUi
import javax.inject.Inject

class LaunchMapper @Inject constructor() {

    fun toLaunches(response: LaunchDataResponse): LaunchConfigUi {
        return LaunchConfigUi(launchList = response.mapNotNull { toLaunch(it) })
    }

    private fun toLaunch(response: LaunchDataResponseItem): LaunchListUi {
        response.let {
            return LaunchListUi(
                missionName = it.missionName,
                launchYear = response.launchYear,
                rocketName = response.rocket?.rocketName,
                missionPatch = response.links?.missionPatch,
                details = response.details,
                youtubeId = response.links?.youtubeId,
                launchSuccess = response.launchSuccess
            )
        }
    }
}