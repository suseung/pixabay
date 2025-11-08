package com.tving.data

import com.tving.data.model.toDomain
import com.tving.data.remote.VideoRemoteDataSource
import com.tving.data.service.VideoApi
import com.tving.domain.model.VideoInfoEntity
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

internal class VideoRemoteDataSourceImpl @Inject constructor(
    private val videoApi: VideoApi
): VideoRemoteDataSource {

    override suspend fun getVideoInfoByKeyword(keyword: String): VideoInfoEntity {
        val encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString())
        return videoApi.getVideoInfo(encodedKeyword).toDomain()
    }
}
