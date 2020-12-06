package com.meazza.unsplash.data.network.response

import com.google.gson.annotations.SerializedName

data class UnsplashResult(
    @SerializedName("results")
    val results: List<UnsplashPhoto>
)