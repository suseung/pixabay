package com.tving.data

import com.tving.data.remote.ImageRemoteDataSource
import com.tving.domain.model.ImageInfoEntity
import com.tving.domain.repository.ImageRepository
import javax.inject.Inject

internal class ImageRepositoryImpl @Inject constructor(
    private val imageRemoteDataSource: ImageRemoteDataSource
): ImageRepository {

    override suspend fun getImageInfoByKeyword(keyword: String): List<ImageInfoEntity> {
        return imageRemoteDataSource.getImageInfoByKeyword(keyword)
    }
}
