package com.tving.data.remote

import com.tving.domain.model.VideoInfoEntity

internal interface VideoRemoteDataSource {

    suspend fun getVideoInfoByKeyword(keyword: String): VideoInfoEntity
}
