package com.tving.domain.repository

import com.tving.domain.model.ImageInfoEntity

interface ImageRepository {
    suspend fun getImageInfoByKeyword(keyword: String): List<ImageInfoEntity>
}
