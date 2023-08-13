package com.yusuf.launches.usecase.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LaunchListUi(
    val missionName: String,
    val launchYear: String?,
    val rocketName: String?,
    val missionPatch: String?,
    val details: String?,
    val youtubeId: String?,
    val launchSuccess: Boolean?
): Parcelable