package com.tving.presentation.contentdetail

import com.tving.presentation.common.base.ViewEffect
import com.tving.presentation.common.base.ViewIntent
import com.tving.presentation.common.base.ViewState
import com.tving.presentation.model.DEFAULT_IMAGE_INFO
import com.tving.presentation.model.PixaUiModel

sealed interface ContentDetailIntent: ViewIntent {

    @JvmInline
    value class SetUp(val item: PixaUiModel): ContentDetailIntent
    data object OnToggleLike: ContentDetailIntent
}

data class ContentDetailState(
    val pixaItemInfo: PixaUiModel = DEFAULT_IMAGE_INFO
): ViewState

sealed interface ContentDetailEffect: ViewEffect
