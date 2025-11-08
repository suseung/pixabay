package com.tving.presentation.model

import com.tving.domain.model.VideoInfoEntity
import com.tving.presentation.common.model.UiModel

data class VideoInfoUiModel(
    val url: String = "",
    val type: String = "",
    val views: Int = 0,
    val downloads: Int = 0,
    val likes: Int = 0,
    val tags: List<String> = emptyList(),
    val isLike: Boolean = false
): UiModel

fun VideoInfoEntity.toUiModel(): VideoInfoUiModel {
    return VideoInfoUiModel(
        url = url,
        type = type,
        views = views,
        downloads = downloads,
        likes = likes,
        tags = tags.split(",").map { it.trim() }
    )
}
