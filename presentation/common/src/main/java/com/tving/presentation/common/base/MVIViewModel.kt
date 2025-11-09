package com.tving.presentation.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

abstract class MVIViewModel<I : ViewIntent, S : ViewState, E : ViewEffect> : ViewModel() {

    abstract fun createInitialState(): S

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        handleException(exception)
    }

    private val initialState: S by lazy { createInitialState() }

    private val _intent: MutableSharedFlow<I> = MutableSharedFlow()
    val intent: SharedFlow<I> = _intent.asSharedFlow()

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state.asStateFlow()

    private val _effect: MutableSharedFlow<E> = MutableSharedFlow()
    val effect: SharedFlow<E> = _effect.asSharedFlow()

    private val _toastEffect: MutableSharedFlow<String> = MutableSharedFlow()
    val toastEffect: SharedFlow<String> = _toastEffect.asSharedFlow()

    abstract suspend fun processIntent(intent: I)

    private val _signalState = MutableStateFlow(SignalState.INITIALIZE)
    val signalState: StateFlow<SignalState> = _signalState

    private val refreshSignal = MutableSharedFlow<SignalState>()

    protected val loadDataSignal: Flow<SignalState> = flow {
        emit(SignalState.INITIALIZE)
        emitAll(refreshSignal)
    }

    open fun onRefresh(signalState: SignalState = SignalState.REFRESH) =
        launch {
            _signalState.value = signalState
            refreshSignal.emit(signalState)
        }

    fun dispatch(intent: I) {
        launch { _intent.emit(intent) }
    }

    init {
        launch {
            intent.collect { processIntent(it) }
        }
    }

    protected fun setState(action: S.() -> S) {
        val result = state.value.action()
        _state.value = result

    }

    protected fun setEffect(builder: () -> E) {
        launch {
            _effect.emit(builder())
        }
    }

    protected fun setToastEffect(builder: () -> String) {
        launch {
            _toastEffect.emit(builder())
        }
    }

    protected inline fun <reified S : ViewState> currentStateIf(action: S.() -> Unit) {
        val currentState = state.value
        if (currentState is S) {
            currentState.action()
        }
    }

    protected fun launch(
        errorHandler: CoroutineExceptionHandler = this.errorHandler,
        block: suspend CoroutineScope.() -> Unit
    ): Job = (viewModelScope + errorHandler).launch(block = block)

    protected open fun handleException(exception: Throwable) {
        exception.message?.let {
            setToastEffect { it }
        }
    }
}
