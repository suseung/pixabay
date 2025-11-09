package com.tving.presentation.home

import com.tving.presentation.common.base.ViewEffect
import com.tving.presentation.common.base.ViewIntent
import com.tving.presentation.common.base.ViewState
import com.tving.presentation.model.ImageInfoUiModel
import com.tving.presentation.model.PixaUiModel
import com.tving.presentation.model.VideoInfoUiModel

sealed interface HomeIntent: ViewIntent {

    @JvmInline
    value class OnChangeInput(val input: String): HomeIntent

    @JvmInline
    value class OnClickItem(val pixaItemInfo: PixaUiModel): HomeIntent
    data object OnClearInput: HomeIntent
}

sealed interface HomeState: ViewState {
    object Loading: HomeState

    data class Success(
        val input: String = "",
        val videoUri: String = "",
        val videoInfo: VideoInfoUiModel = VideoInfoUiModel(),
        val images: List<ImageInfoUiModel> = emptyList()
    ): HomeState
}


sealed interface HomeEffect: ViewEffect {

    @JvmInline
    value class OnNavigateToContentDetail(val item: PixaUiModel): HomeEffect
}
