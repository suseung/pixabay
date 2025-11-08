package com.tving.presentation.contentdetail

import com.tving.presentation.common.base.ViewEffect
import com.tving.presentation.common.base.ViewIntent
import com.tving.presentation.common.base.ViewState
import com.tving.presentation.model.DEFAULT_IMAGE_INFO
import com.tving.presentation.model.ImageInfoUiModel

sealed interface ContentDetailIntent: ViewIntent {
    data object OnToggleLike: ContentDetailIntent
}

data class ContentDetailState(
    val imageInfo: ImageInfoUiModel = DEFAULT_IMAGE_INFO
): ViewState

sealed interface ContentDetailEffect: ViewEffect
