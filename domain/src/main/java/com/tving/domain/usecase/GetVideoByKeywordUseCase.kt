package com.tving.domain.usecase

import com.tving.domain.base.FlowUseCase
import com.tving.domain.di.IoDispatcher
import com.tving.domain.model.VideoInfoEntity
import com.tving.domain.repository.VideoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetVideoByKeywordUseCase @Inject constructor(
    private val videoRepository: VideoRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<String, VideoInfoEntity>(ioDispatcher) {

    override fun execute(params: String): Flow<VideoInfoEntity> = flow {
        emit(videoRepository.getVideoInfoByKeyword(params))
    }
}
