package com.meazza.unsplash.data.repository

import com.meazza.unsplash.data.network.response.UnsplashResult
import com.meazza.unsplash.data.network.service.UnsplashService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class NetworkRepositoryImpl @Inject constructor(private val unsplashService: UnsplashService) :
    NetworkRepository {

    override suspend fun getResult(query: String, page: Int, perPage: Int): UnsplashResult =
        unsplashService.searchPhotos(query, page, perPage)
}