package com.tving.presentation.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tving.designsystem.R
import com.tving.presentation.model.ImageInfoUiModel

@Composable
fun ImageCard(
    modifier: Modifier,
    imageInfo: ImageInfoUiModel,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopEnd
    ) {
        AsyncImage(
            model = imageInfo.url,
            contentDescription = "image",
            contentScale = ContentScale.FillBounds,
        )
        Icon(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    end = 16.dp
                )
                .size(30.dp),
            imageVector = ImageVector.vectorResource(
                id = if (imageInfo.isLike) R.drawable.ic_arrow_back else R.drawable.ic_erase
            ),
            contentDescription = "like icon",
            tint = Color.Unspecified
        )
    }
}
