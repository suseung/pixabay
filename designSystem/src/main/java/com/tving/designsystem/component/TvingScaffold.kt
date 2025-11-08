package com.tving.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TvingScaffold(
    modifier: Modifier = Modifier,
    topAppBarColor: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    navigationIcon: @Composable () -> Unit = {},
    titleContent: @Composable () -> Unit = {},
    titleThickness: Dp = 0.5.dp,
    actions: @Composable RowScope.() -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    contents: @Composable (PaddingValues) -> Unit = {}
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TvingTopAppbar(
                navigationIcon = navigationIcon,
                titleContent = titleContent,
                actions = actions,
                thickness = titleThickness,
                colors = topAppBarColor
            )
        },
        bottomBar = bottomBar
    ) { paddingValues ->
        contents(paddingValues)
    }
}
