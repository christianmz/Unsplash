package com.meazza.unsplash.data.repository

import com.meazza.unsplash.data.network.response.UnsplashResult

interface NetworkRepository {

    suspend fun getResult(query: String, page: Int, perPage: Int): UnsplashResult
}