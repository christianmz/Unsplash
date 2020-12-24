package com.meazza.unsplash.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.meazza.unsplash.databinding.LayoutUnsplashPhotoFooterBinding

class UnsplashPhotoLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<UnsplashPhotoLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = LoadStateViewHolder(
        LayoutUnsplashPhotoFooterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        holder.itemBinding.run {

            pbRetry.isVisible = loadState is LoadState.Loading
            tvRetry.isVisible = loadState !is LoadState.Loading
            btnRetry.isVisible = loadState !is LoadState.Loading

            btnRetry.setOnClickListener {
                retry.invoke()
            }
        }
    }

    class LoadStateViewHolder(val itemBinding: LayoutUnsplashPhotoFooterBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}