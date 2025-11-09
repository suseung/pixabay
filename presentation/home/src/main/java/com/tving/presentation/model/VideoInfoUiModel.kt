package com.tving.presentation.model

import com.tving.domain.model.VideoInfoEntity
import kotlinx.serialization.Serializable

@Serializable
data class VideoInfoUiModel(
    override val userName: String = "",
    override val url: String = "",
    override val itemType: String = "",
    override val views: Int = 0,
    override val downloads: Int = 0,
    override val likes: Int = 0,
    override val tags: List<String> = emptyList(),
    override val isLike: Boolean = false,
    override val isVideo: Boolean = true
): PixaUiModel()

fun VideoInfoEntity.toUiModel(): VideoInfoUiModel {
    return VideoInfoUiModel(
        userName = userName,
        url = url,
        itemType = type,
        views = views,
        downloads = downloads,
        likes = likes,
        tags = tags.split(",").map { it.trim() }
    )
}
