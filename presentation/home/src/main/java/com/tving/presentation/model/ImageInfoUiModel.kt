package com.tving.presentation.model

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
