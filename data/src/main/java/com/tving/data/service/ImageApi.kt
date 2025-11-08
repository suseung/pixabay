package com.tving.data.service

import com.tving.data.BuildConfig
import com.tving.data.model.ImageInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ImageApi {

    @GET("api")
    suspend fun getImageInfo(
        @Query("q") query: String,
        @Query("key") key: String = BuildConfig.apiKey
    ): ImageInfoResponse
}
