package com.tving.data.service

import com.tving.data.BuildConfig
import com.tving.data.model.VideoInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface VideoApi {

    @GET("api/videos/")
    suspend fun getVideoInfo(
        @Query("q") query: String,
        @Query("key") key: String = BuildConfig.apiKey
    ): VideoInfoResponse
}
