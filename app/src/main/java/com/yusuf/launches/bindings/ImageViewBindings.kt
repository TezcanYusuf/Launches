package com.yusuf.launches.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.util.*

@BindingAdapter("load_image_url")
fun loadLaunchUrl(imageView: AppCompatImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .timeout(15000)
        .into(imageView)
}