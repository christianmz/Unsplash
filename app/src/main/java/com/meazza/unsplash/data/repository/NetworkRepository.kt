package com.meazza.unsplash.data.repository

import androidx.paging.PagingData
import com.meazza.unsplash.data.network.response.UnsplashPhoto
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    fun getResult(query: String): Flow<PagingData<UnsplashPhoto>>
}