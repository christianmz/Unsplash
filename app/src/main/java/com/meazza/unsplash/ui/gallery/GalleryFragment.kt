package com.meazza.unsplash.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meazza.unsplash.R
import com.meazza.unsplash.databinding.FragmentGalleryBinding
import com.meazza.unsplash.ui.gallery.adapter.UnsplashPhotoLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val galleryViewModel by viewModels<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentGalleryBinding>(view)?.apply {
            lifecycleOwner = this@GalleryFragment
            viewModel = galleryViewModel
        }

        getPhotos()
    }

    private fun getPhotos() {
        galleryViewModel.run {
            getPhotos().observe(viewLifecycleOwner) {
                adapter.run {
                    submitData(viewLifecycleOwner.lifecycle, it)
                    withLoadStateHeaderAndFooter(
                        header = UnsplashPhotoLoadStateAdapter { retry() },
                        footer = UnsplashPhotoLoadStateAdapter { retry() }
                    )
                }
            }
        }
    }
}