package com.tving.presentation.common.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.tving.presentation.common.ext.noRippleClickable
import com.tving.presentation.common.utils.ThemePreview

@Composable
fun CommonBottomBar(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {},
    onNavigateToFavorite: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalDivider()
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .noRippleClickable { onNavigateToHome() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = onNavigateToHome) {
                    Icon(
                        imageVector = ImageVector.vectorResource(com.tving.designsystem.R.drawable.ic_home),
                        tint = Color.Unspecified,
                        contentDescription = "home button"
                    )
                }
                Text(text = "Home")
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .noRippleClickable { onNavigateToFavorite() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = onNavigateToFavorite) {
                    Icon(
                        imageVector = ImageVector.vectorResource(com.tving.designsystem.R.drawable.ic_arrow_back),
                        tint = Color.Unspecified,
                        contentDescription = "favorite button"
                    )
                }
                Text(text = "Favorite")
            }
        }
    }
}

@ThemePreview
@Composable
private fun CommonBottomBarPreview() {
    CommonBottomBar()
}
