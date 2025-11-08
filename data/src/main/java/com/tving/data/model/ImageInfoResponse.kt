package com.tving.data.model

import com.tving.domain.model.ImageInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ImageInfoResponse(
    @SerialName("hits") val hits: List<ImageHitResponse>
): DataModel

@Serializable
internal data class ImageHitResponse(
    @SerialName("type") val type: String,
    @SerialName("previewURL") val imagUrl: String,
    @SerialName("views") val views: Int,
    @SerialName("downloads") val downloads: Int,
    @SerialName("likes") val likes: Int,
    @SerialName("tags") val tags: String,
): DataModel

internal fun ImageHitResponse.toDomain(): ImageInfoEntity {
    return ImageInfoEntity(
        url = imagUrl,
        type = type,
        views = views,
        downloads = downloads,
        likes = likes,
        tags = tags
    )
}
