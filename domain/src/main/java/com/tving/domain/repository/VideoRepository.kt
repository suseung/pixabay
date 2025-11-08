package com.tving.domain.repository

import com.tving.domain.model.VideoInfoEntity

interface VideoRepository {
    suspend fun getVideoInfoByKeyword(keyword: String): VideoInfoEntity
}
