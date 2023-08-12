package com.yusuf.launches.ui.list

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusuf.launches.R
import com.yusuf.launches.base.BaseFragment
import com.yusuf.launches.databinding.FragmentLaunchesListBinding
import com.yusuf.launches.enums.Keys
import com.yusuf.launches.ext.navigateSafe
import com.yusuf.launches.ext.observe
import com.yusuf.launches.ext.observeEvent
import com.yusuf.launches.usecase.ui.LaunchConfigUi
import com.yusuf.launches.usecase.ui.LaunchListUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchesListFragment : BaseFragment<LaunchesListViewModel, FragmentLaunchesListBinding>() {

    private val launchesListAdapter: LaunchesListAdapter by lazy {
        LaunchesListAdapter(
            viewModel
        )
    }

    private var searchTimer: CountDownTimer? = null

    override fun viewModelClass() = LaunchesListViewModel::class.java

    override fun getResourceLayoutId() = R.layout.fragment_launches_list

    override fun onInitDataBinding() {
        observeEvent(viewModel.event, ::onViewEvent)
        observe(viewModel.launches, ::onLaunchesChanged)
        observe(viewModel.filteredList, ::onFilteredListChanged)

        viewBinding.vehicleListRecyclerView.also {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter = launchesListAdapter
        }

        viewBinding.refreshSwipeLayout.setOnRefreshListener {
            viewModel.getLaunches()
            viewBinding.searchTv.setQuery("", false)
            viewBinding.refreshSwipeLayout.isRefreshing = false
        }

        searchTvActions()
    }

    private fun onViewEvent(launchListViewEvent: LaunchListViewEvent) {
        when(launchListViewEvent) {
            is LaunchListViewEvent.NavigateDetail -> {
                val bundle = Bundle().apply {
                    putParcelable(Keys.LAUNCH, launchListViewEvent.launch)
                }
                navigateSafe(R.id.action_launchesListFragment_to_launchDetailFragment, bundle = bundle)
            }
        }
    }

    private fun onLaunchesChanged(launchConfigUi: LaunchConfigUi) {
        launchesListAdapter.submitList(launchConfigUi.launchList)
    }

    private fun onFilteredListChanged(filteredList: List<LaunchListUi>) {
        launchesListAdapter.submitList(filteredList)
    }

    private fun searchTvActions() {
        viewBinding.searchTv.setOnClickListener {
            viewBinding.searchTv.isIconified = false
        }

        viewBinding.searchTv.setOnCloseListener {
            filterLaunches("")
            false
        }

        viewBinding.searchTv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {

                if (newText.trim().isEmpty()) {
                    filterLaunches("")
                } else {
                    try {
                        searchTimer?.cancel()
                    } catch (_: Exception) {
                    }
                    startTimer(newText.trim())
                }

                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
    }

    private fun startTimer(text: String) {
        try {
            searchTimer?.cancel()
            searchTimer = (object : CountDownTimer((1 * 1000).toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    if (viewBinding.searchTv.query.trim() != "") {
                        filterLaunches(text)
                    }
                }
            })
            searchTimer?.start()
        } catch (_: IllegalStateException) {
        }
    }

    private fun filterLaunches(filterValue: String) {
        searchTimer?.cancel()
        viewModel.filterWithSearch(filterValue = filterValue)
    }

    override fun onDestroy() {
        super.onDestroy()
        searchTimer?.cancel()
    }

}