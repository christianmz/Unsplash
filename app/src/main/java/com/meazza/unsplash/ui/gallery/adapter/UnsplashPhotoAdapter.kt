package com.meazza.unsplash.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.meazza.unsplash.R
import com.meazza.unsplash.data.network.response.UnsplashPhoto
import com.meazza.unsplash.databinding.LayoutUnsplashPhotoBinding

object UnsplashPhotoAdapter :
    PagingDataAdapter<UnsplashPhoto, UnsplashPhotoAdapter.UnsplashViewHolder>(UnsplashPhotoDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UnsplashViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_unsplash_photo,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UnsplashViewHolder, position: Int) {
        holder.itemBinding.run {
            photo = getItem(position)
        }
    }

    class UnsplashViewHolder(val itemBinding: LayoutUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}