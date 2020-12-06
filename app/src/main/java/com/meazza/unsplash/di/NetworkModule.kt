package com.meazza.unsplash.di

import com.meazza.unsplash.data.network.service.UnsplashService
import com.meazza.unsplash.data.repository.NetworkRepository
import com.meazza.unsplash.data.repository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityRetainedComponent::class)
object NetworkModule {

    @ActivityRetainedScoped
    @Provides
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @ActivityRetainedScoped
    @Provides
    fun providesUnsplashService(retrofit: Retrofit): UnsplashService =
        retrofit.create(UnsplashService::class.java)

    @ActivityRetainedScoped
    @Provides
    fun providesNetworkRepository(unsplashService: UnsplashService): NetworkRepository =
        NetworkRepositoryImpl(unsplashService)
}