package com.meazza.unsplash.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.meazza.unsplash.R

fun ImageView.loadUrl(url: String?) {

    val factory: DrawableCrossFadeFactory = DrawableCrossFadeFactory.Builder()
        .setCrossFadeEnabled(true).build()

    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .error(R.drawable.ic_broken_image)
        .override(400, 400)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
        .waitForLayout()
}