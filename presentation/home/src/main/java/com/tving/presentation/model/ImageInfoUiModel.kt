package com.tving.presentation.model

import com.tving.domain.model.ImageInfoEntity
import kotlinx.serialization.Serializable

@Serializable
sealed class PixaUiModel {
    abstract val userName: String
    abstract val url: String
    abstract val itemType: String
    abstract val views: Int
    abstract val likes: Int
    abstract val downloads: Int
    abstract val tags: List<String>
    abstract val isLike: Boolean
    abstract val isVideo: Boolean
}

@Serializable
data class ImageInfoUiModel(
    override val userName: String = "",
    override val url: String = "",
    override val itemType: String = "",
    override val views: Int = 0,
    override val likes: Int = 0,
    override val downloads: Int = 0,
    override val tags: List<String> = emptyList(),
    override val isLike: Boolean = false,
    override val isVideo: Boolean = false
): PixaUiModel()

fun ImageInfoEntity.toUiModel(): ImageInfoUiModel {
    return ImageInfoUiModel(
        userName = userName,
        url = url,
        itemType = type,
        views = views,
        downloads = downloads,
        likes = likes,
        tags = tags.split(",").map { it.trim() }
    )
}

val DEFAULT_IMAGE_INFO = ImageInfoUiModel(
    userName = "user",
    itemType = "Photo",
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
