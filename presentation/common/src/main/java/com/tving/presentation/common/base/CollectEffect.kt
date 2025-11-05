package com.tving.presentation.common.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.tving.presentation.common.ext.toastS
import kotlinx.coroutines.launch

@Composable
fun CollectEffect(
    viewModel: MVIViewModel<*, *, *>,
    processEffect: (ViewEffect) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(true) {
        launch {
            viewModel.effect.collect { processEffect(it) }
        }
        launch {
            viewModel.toastEffect.collect { context.toastS(it) }
        }
    }
}
