package com.tving.data.model

import com.tving.domain.model.VideoInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class VideoInfoResponse(
    @SerialName("hits") val hits: List<VideoHitResponse>
): DataModel

@Serializable
internal data class VideoHitResponse(
    @SerialName("user") val userName: String,
    @SerialName("type") val type: String,
    @SerialName("videos") val videos: VideoResponse,
    @SerialName("views") val views: Int,
    @SerialName("downloads") val downloads: Int,
    @SerialName("likes") val likes: Int,
    @SerialName("tags") val tags: String
): DataModel

@Serializable
internal data class VideoResponse(
    @SerialName("small") val smallUrlInfo: VideoUrlInfoResponse
): DataModel

@Serializable
internal data class VideoUrlInfoResponse(
    @SerialName("url") val url: String
): DataModel


internal fun VideoInfoResponse.toDomain(): VideoInfoEntity {
    val item = hits.first()
    return VideoInfoEntity(
        userName = item.userName,
        url = item.videos.smallUrlInfo.url,
        type = item.type,
        views = item.views,
        downloads = item.downloads,
        likes = item.likes,
        tags = item.tags
    )
}
