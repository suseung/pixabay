package com.tving.domain.usecase

import com.tving.domain.base.FlowUseCase
import com.tving.domain.di.IoDispatcher
import com.tving.domain.model.ImageInfoEntity
import com.tving.domain.repository.ImageRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetImageByKeywordUseCase @Inject constructor(
    private val imageRepository: ImageRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
): FlowUseCase<String, List<ImageInfoEntity>>(ioDispatcher) {

    override fun execute(params: String): Flow<List<ImageInfoEntity>> = flow {
        emit(imageRepository.getImageInfoByKeyword(params))
    }
}
