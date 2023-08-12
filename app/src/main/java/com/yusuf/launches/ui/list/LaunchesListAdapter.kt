package com.yusuf.launches.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.launches.base.BaseListAdapter
import com.yusuf.launches.base.BaseViewHolder
import com.yusuf.launches.databinding.ItemLaunchBinding
import com.yusuf.launches.usecase.ui.LaunchListUi

class LaunchesListAdapter(
    private val viewModel: LaunchesListViewModel
) : BaseListAdapter<LaunchListUi>(itemsSame = { old, new -> old == new },
    contentsSame = { old, new -> old == new }) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LaunchViewHolder -> holder.bind(viewModel, getItem(position))
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, inflater: LayoutInflater, viewType: Int
    ): RecyclerView.ViewHolder {
        return LaunchViewHolder(parent, inflater)
    }
}

class LaunchViewHolder(
    parent: ViewGroup, inflater: LayoutInflater
) : BaseViewHolder<ItemLaunchBinding>(
    binding = ItemLaunchBinding.inflate(inflater, parent, false)
) {
    fun bind(
        viewModel: LaunchesListViewModel, item: LaunchListUi
    ) {
        binding.launch = item
        binding.root.setOnClickListener {
            viewModel.handleItemClick(item)
        }
    }
}