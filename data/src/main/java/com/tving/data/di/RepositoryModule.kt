package com.tving.data.di

import com.tving.data.ImageRemoteDataSourceImpl
import com.tving.data.ImageRepositoryImpl
import com.tving.data.VideoRemoteDataSourceImpl
import com.tving.data.VideoRepositoryImpl
import com.tving.data.remote.ImageRemoteDataSource
import com.tving.data.remote.VideoRemoteDataSource
import com.tving.domain.repository.ImageRepository
import com.tving.domain.repository.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVideoRepository(
        videoRepositoryImpl: VideoRepositoryImpl
    ): VideoRepository

    @Binds
    @Singleton
    abstract fun bindVideoRemoteDataSource(
        videoRemoteDataSourceImpl: VideoRemoteDataSourceImpl
    ): VideoRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindImageRepository(
        imageRepositoryImpl: ImageRepositoryImpl
    ): ImageRepository

    @Binds
    @Singleton
    abstract fun bindImageRemoteDataSource(
        imageRemoteDataSourceImpl: ImageRemoteDataSourceImpl
    ): ImageRemoteDataSource
}
