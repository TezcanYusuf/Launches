package com.yusuf.launches.ui.detail

import android.os.Build
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.yusuf.launches.R
import com.yusuf.launches.base.BaseFragment
import com.yusuf.launches.databinding.FragmentLaunchDetailBinding
import com.yusuf.launches.enums.Keys
import com.yusuf.launches.ext.navigateSafe
import com.yusuf.launches.usecase.ui.LaunchListUi
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LaunchDetailFragment : BaseFragment<LaunchDetailViewModel, FragmentLaunchDetailBinding>() {

    override fun viewModelClass() = LaunchDetailViewModel::class.java

    override fun getResourceLayoutId() = R.layout.fragment_launch_detail

    override fun onInitDataBinding() {
        viewBinding.toolbar.setNavigationOnClickListener {
            navigateSafe(R.id.action_launchDetailFragment_to_launchesListFragment)
        }

        initView()
    }

    private fun initView() {
        val launch = getLaunch()
        viewBinding.launch = getLaunch()
        launch?.let { playVideo(launch = it) }
    }

    private fun playVideo(launch: LaunchListUi) {
        lifecycle.addObserver(viewBinding.youtubePlayerView)
        viewBinding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = launch.youtubeId
                videoId?.let { youTubePlayer.loadVideo(it, 0f) }
                youTubePlayer.play()
            }
        })
    }

    private fun getLaunch(): LaunchListUi? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(Keys.LAUNCH, LaunchListUi::class.java)
        } else {
            arguments?.get(Keys.LAUNCH) as LaunchListUi
        }
    }
}