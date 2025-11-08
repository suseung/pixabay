package com.tving.data

import com.tving.data.model.ImageHitResponse
import com.tving.data.model.toDomain
import com.tving.data.remote.ImageRemoteDataSource
import com.tving.data.service.ImageApi
import com.tving.domain.model.ImageInfoEntity
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

internal class ImageRemoteDataSourceImpl @Inject constructor(
    private val imageApi: ImageApi
): ImageRemoteDataSource {

    override suspend fun getImageInfoByKeyword(keyword: String): List<ImageInfoEntity> {
        val encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString())
        return imageApi.getImageInfo(encodedKeyword).hits.map(ImageHitResponse::toDomain)
    }
}
