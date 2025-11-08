package com.tving.domain.model

data class VideoInfoEntity(
    val url: String,
    val type: String,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val tags: String
): DomainModel
