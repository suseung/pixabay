package com.tving.data

import androidx.compose.runtime.key
import com.tving.data.remote.VideoRemoteDataSource
import com.tving.domain.model.VideoInfoEntity
import com.tving.domain.repository.VideoRepository
import javax.inject.Inject

internal class VideoRepositoryImpl @Inject constructor(
    private val videoRemoteDateSource: VideoRemoteDataSource
): VideoRepository {

    override suspend fun getVideoInfoByKeyword(keyword: String): VideoInfoEntity {
        return videoRemoteDateSource.getVideoInfoByKeyword(keyword)
    }
}
