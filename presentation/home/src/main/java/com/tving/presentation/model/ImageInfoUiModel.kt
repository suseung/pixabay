package com.tving.presentation.model

import com.tving.domain.model.ImageInfoEntity

data class ImageInfoUiModel(
    val imageUrl: String = "",
    val title: String = "",
    val type: String = "",
    val views: Int = 0,
    val likes: Int = 0,
    val downloads: Int = 0,
    val isLike: Boolean = false,
    val tags: List<String> = emptyList()
) {
    val tagsToString: String
        get() = tags.joinToString(" • ")
}

fun ImageInfoEntity.toUiModel(): ImageInfoUiModel {
    return ImageInfoUiModel(
        imageUrl = url,
        type = type,
        views = views,
        downloads = downloads,
        likes = likes,
        tags = tags.split(",").map { it.trim() }
    )
}

val DEFAULT_IMAGE_INFO = ImageInfoUiModel(
    title = "title",
    type = "Photo",
    views = 2781,
    likes = 9,
    downloads = 9,
    tags = listOf(
        "bejaia",
        "algerie",
        "mediterranean",
        "blue",
        "sea",
        "nature",
        "water",
        "bay",
        "coast",
        "clouds",
        "heaven",
        "summer"
    )
)
