package com.tving.presentation.home

import androidx.lifecycle.viewModelScope
import com.tving.domain.base.ApiResult
import com.tving.domain.base.asResult
import com.tving.domain.usecase.GetVideoByKeywordUseCase
import com.tving.presentation.common.base.MVIViewModel
import com.tving.presentation.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getVideoByKeywordUseCase: GetVideoByKeywordUseCase,
) : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    override fun createInitialState() = HomeState.Success()

    private var searchJob: Job? = null

    override suspend fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.OnChangeInput -> processChangeInput(intent.input)
            is HomeIntent.OnClearInput -> processChangeInput("")
        }
    }

    private fun processChangeInput(input: String) = currentStateIf<HomeState.Success> {
        setState {
            copy(
                input = input,
                videoUri = ""
            )
        }
        if (input.isNotEmpty()) {
            searchJob?.cancel()
            processSearch()
        }
    }

    private fun processSearch() = currentStateIf<HomeState.Success> {
        searchJob = viewModelScope.launch {
            delay(1000)
            getVideoByKeywordUseCase(input)
                .asResult()
                .collect { apiResult ->
                    when (apiResult) {
                        is ApiResult.Loading -> return@collect
                        is ApiResult.Success -> {
                            val data = apiResult.data.toUiModel()
                            setState {
                                copy(videoUri = data.url)
                            }
                        }

                        is ApiResult.Error -> {
                            setToastEffect(
                                apiResult.exception.message ?: "error"
                            )
                        }
                    }
                }
        }
    }
}
