package com.tving.presentation.contentdetail

import com.tving.presentation.common.base.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentDetailViewModel @Inject constructor(

): MVIViewModel<ContentDetailIntent, ContentDetailState, ContentDetailEffect>() {

    override fun createInitialState() = ContentDetailState()

    override suspend fun processIntent(intent: ContentDetailIntent) {
        when (intent) {
            is ContentDetailIntent.OnToggleLike -> processToggleLike()

        }
    }

    private fun processToggleLike() = currentStateIf<ContentDetailState> {
        val previousLike = imageInfo.isLike
        setState {
            copy(imageInfo = imageInfo.copy(isLike = previousLike.not()))
        }
    }
}
