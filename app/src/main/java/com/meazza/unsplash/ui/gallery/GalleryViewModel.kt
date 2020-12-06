package com.meazza.unsplash.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.meazza.unsplash.data.repository.NetworkRepository

class GalleryViewModel @ViewModelInject constructor(private val repository: NetworkRepository) :
    ViewModel()