package com.yusuf.launches.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yusuf.launches.base.BaseViewModel
import com.yusuf.launches.ext.Event
import com.yusuf.launches.ext.doOnSuccess
import com.yusuf.launches.usecase.LaunchUseCase
import com.yusuf.launches.usecase.ui.LaunchConfigUi
import com.yusuf.launches.usecase.ui.LaunchListUi
import com.yusuf.launches.utils.StringUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class LaunchesListViewModel @Inject constructor(
    private val launchUseCase: LaunchUseCase
) : BaseViewModel() {

    private val _event = MutableLiveData<Event<LaunchListViewEvent>>()
    val event: LiveData<Event<LaunchListViewEvent>> = _event

    private val _launches = MutableLiveData<LaunchConfigUi>()
    val launches: LiveData<LaunchConfigUi> = _launches

    private val _filteredList = MutableLiveData<List<LaunchListUi>>()
    val filteredList: LiveData<List<LaunchListUi>> = _filteredList

    init {
        getLaunches()
    }

    fun getLaunches() {
        if ((launches.value?.launchList?.size ?: 0) == 0) {
            launchUseCase(Unit).doOnSuccess {
                _launches.postValue(it)
            }.launchIn(viewModelScope)
        } else {
            _launches.postValue(launches.value)
        }

    }

    fun handleItemClick(launch: LaunchListUi) {
        _event.postValue(Event(LaunchListViewEvent.NavigateDetail(launch = launch)))
    }

    fun filterWithSearch(filterValue: String) {
        if (filterValue == "") {
            _filteredList.postValue(launches.value?.launchList)
        } else {
            val newList: ArrayList<LaunchListUi> = ArrayList()
            launches.value?.launchList?.forEach { launch ->
                val replacedRocketYear = launch.launchYear?.let { StringUtils.prepareForQuery(it) }

                val replacedMissionName = launch.missionName.let { StringUtils.prepareForQuery(it) }

                val replacedFilterValue = StringUtils.prepareForQuery(filterValue)

                if ((replacedRocketYear?.contains(replacedFilterValue)
                        ?: "") == true || replacedMissionName.contains(replacedFilterValue)
                ) {
                    newList.add(launch)
                }
            }
            _filteredList.postValue(newList)
        }
    }
}