package com.tving.data.remote

import com.tving.domain.model.ImageInfoEntity

interface ImageRemoteDataSource {
    suspend fun getImageInfoByKeyword(keyword: String): List<ImageInfoEntity>
}
