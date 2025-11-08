package com.tving.presentation.contentdetail.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.tving.presentation.common.utils.ThemePreview

@Composable
fun ImageInfoHeader(
    modifier: Modifier = Modifier,
    title: String,
    isLike: Boolean,
    onClickLike: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    shape = CircleShape,
                    color = Color.Black
                )
                .clip(CircleShape)
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title.first().uppercase()
            )
        }
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = title
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onClickLike) {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = if (isLike) {
                        com.tving.designsystem.R.drawable.ic_arrow_back
                    } else {
                        com.tving.designsystem.R.drawable.ic_erase
                    }
                ),
                contentDescription = "like button",
                tint = Color.Unspecified
            )
        }
    }
}

@ThemePreview
@Composable
private fun ImageInfoHeaderPreview() {
    ImageInfoHeader(
        title = "SLPix",
        isLike = false
    )
}
