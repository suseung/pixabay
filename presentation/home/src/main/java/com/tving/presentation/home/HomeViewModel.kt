package com.tving.presentation.home

import com.tving.presentation.common.base.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    override fun createInitialState() = HomeState.Success()

    override suspend fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.OnChangeInput -> processChangeInput(intent.input)
            is HomeIntent.OnClearInput -> processChangeInput("")
        }
    }

    private fun processChangeInput(input: String) = currentStateIf<HomeState.Success> {
        setState {
            copy(input = input)
        }
    }
}
