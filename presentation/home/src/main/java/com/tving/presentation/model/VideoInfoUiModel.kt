package com.tving.presentation.model

import com.tving.domain.model.VideoInfoEntity
import com.tving.presentation.common.model.UiModel

data class VideoInfoUiModel(
    val url: String,
    val type: String,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val tags: List<String>
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
