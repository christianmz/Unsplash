package com.meazza.unsplash.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.meazza.unsplash.data.repository.NetworkRepository
import com.meazza.unsplash.ui.gallery.adapter.UnsplashPhotoAdapter
import kotlinx.coroutines.flow.collect

class GalleryViewModel @ViewModelInject constructor(
    private val repository: NetworkRepository
) : ViewModel() {

    val adapter = UnsplashPhotoAdapter

    fun getPhotos() = liveData {
        repository.getResult("Girls").cachedIn(viewModelScope).collect {
            emit(it)
        }
    }
}