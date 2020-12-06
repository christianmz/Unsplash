package com.meazza.unsplash.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.meazza.unsplash.util.loadUrl

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, url: String?) {
    imageView.loadUrl(url)
}