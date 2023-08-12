package com.yusuf.launches.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.yusuf.launches.BR

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> :
    BaseVmDbFragment<VM, DB>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.setVariable(BR._all, viewModel)
        onInitDataBinding()
    }

    abstract fun onInitDataBinding()
}
