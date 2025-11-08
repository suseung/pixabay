package com.tving.data

import com.tving.data.model.toDomain
import com.tving.data.remote.VideoRemoteDataSource
import com.tving.data.service.VideoApi
import com.tving.domain.model.VideoInfoEntity
import javax.inject.Inject

internal class VideoRemoteDataSourceImpl @Inject constructor(
    private val videoApi: VideoApi
): VideoRemoteDataSource {

    override suspend fun getVideoInfoByKeyword(keyword: String): VideoInfoEntity {
        return videoApi.getVideoInfo(keyword).toDomain()
    }
}
