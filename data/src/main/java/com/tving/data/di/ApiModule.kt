package com.tving.data.di

import com.tving.data.service.ImageApi
import com.tving.data.service.VideoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    fun provideVideoApi(
        retrofit: Retrofit
    ): VideoApi = retrofit.create(VideoApi::class.java)

    @Provides
    @Singleton
    fun provideImageApi(
        retrofit: Retrofit
    ): ImageApi = retrofit.create(ImageApi::class.java)
}
