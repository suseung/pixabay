package com.tving.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TvingTopAppbar(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    titleContent: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        TopAppBar(
            title = { titleContent() },
            navigationIcon = navigationIcon,
            actions = actions,
            colors = colors
        )
        HorizontalDivider(thickness = thickness, color = DividerDefaults.color)
    }
}
