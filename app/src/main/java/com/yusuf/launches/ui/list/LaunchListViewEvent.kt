package com.yusuf.launches.ui.list

import com.yusuf.launches.usecase.ui.LaunchListUi

sealed class LaunchListViewEvent {

    data class NavigateDetail(val launch: LaunchListUi): LaunchListViewEvent()
}