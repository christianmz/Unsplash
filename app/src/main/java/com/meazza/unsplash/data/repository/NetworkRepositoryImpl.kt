package com.meazza.unsplash.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.meazza.unsplash.data.network.paging.UnsplashPagingSource
import com.meazza.unsplash.data.network.response.UnsplashPhoto
import com.meazza.unsplash.data.network.service.UnsplashService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class NetworkRepositoryImpl @Inject constructor(private val unsplashService: UnsplashService) :
    NetworkRepository {

    override fun getResult(query: String): Flow<PagingData<UnsplashPhoto>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashService, query) }
        ).flow
}