package com.tving.presentation.contentdetail

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import com.tving.presentation.common.base.MVIViewModel
import com.tving.presentation.model.ImageInfoUiModel
import com.tving.presentation.model.PixaUiModel
import com.tving.presentation.model.VideoInfoUiModel
import com.tving.presentation.util.JsonUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): MVIViewModel<ContentDetailIntent, ContentDetailState, ContentDetailEffect>() {

    override fun createInitialState() = ContentDetailState()

    init {
        savedStateHandle.get<String>("item")?.let { encodedJson ->
            val item = JsonUtil.pixaJson.decodeFromString<PixaUiModel>(Uri.decode(encodedJson))
            processSetUp(item)
        }
    }

    override suspend fun processIntent(intent: ContentDetailIntent) {
        when (intent) {
            is ContentDetailIntent.SetUp -> processSetUp(intent.item)
            is ContentDetailIntent.OnToggleLike -> processToggleLike()
        }
    }

    private fun processSetUp(item: PixaUiModel) {
        currentStateIf<ContentDetailState> {
            setState {
                copy(pixaItemInfo = item)
            }
        }
    }

    private fun processToggleLike() = currentStateIf<ContentDetailState> {
        val previousLike = pixaItemInfo.isLike
        when (val item = pixaItemInfo) {
            is ImageInfoUiModel -> setState {
                copy(pixaItemInfo = item.copy(isLike = previousLike.not()))
            }
            is VideoInfoUiModel -> setState {
                copy(pixaItemInfo = item.copy(isLike = previousLike.not()))
            }
        }
    }
}
