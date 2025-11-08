package com.tving.presentation.home

import com.tving.presentation.common.base.ViewEffect
import com.tving.presentation.common.base.ViewIntent
import com.tving.presentation.common.base.ViewState

sealed interface HomeIntent: ViewIntent {

    @JvmInline
    value class OnChangeInput(val input: String): HomeIntent
    data object OnClearInput: HomeIntent
}

sealed interface HomeState: ViewState {
    object Loading: HomeState

    data class Success(
        val input: String = ""
    ): HomeState
}


sealed interface HomeEffect: ViewEffect
