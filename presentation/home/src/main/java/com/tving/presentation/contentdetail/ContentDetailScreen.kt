package com.tving.presentation.contentdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.tving.designsystem.component.TvingScaffold
import com.tving.presentation.common.component.CommonBottomBar
import com.tving.presentation.common.utils.ThemePreview
import com.tving.presentation.component.VideoPlayer
import com.tving.presentation.contentdetail.component.PixaItemInfoHeader
import com.tving.presentation.contentdetail.component.InfoItem
import com.tving.presentation.model.DEFAULT_IMAGE_INFO
import com.tving.presentation.model.PixaUiModel

@Composable
fun ContentDetailScreen(
    viewModel: ContentDetailViewModel = hiltViewModel(),
    onNavigateToHome: () -> Unit = {},
    onNavPopback: () -> Unit = {}
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val action by remember { mutableStateOf(viewModel::dispatch) }

    TvingScaffold(
        titleContent = {
            Text("ContentDetail")
        },
        bottomBar = {
            CommonBottomBar(
                onNavigateToHome = onNavigateToHome
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavPopback) {
                Icon(
                    imageVector = ImageVector.vectorResource(com.tving.designsystem.R.drawable.ic_arrow_back),
                    tint = Color.Unspecified,
                    contentDescription = "back button"
                )
            }
        }
    ) { paddingValues ->
        ContentDetailContent(
            modifier = Modifier.padding(paddingValues),
            pixaItemInfo = uiState.pixaItemInfo,
            action = action
        )
    }
}

@Composable
fun ContentDetailContent(
    modifier: Modifier = Modifier,
    pixaItemInfo: PixaUiModel,
    action: (ContentDetailIntent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        if (pixaItemInfo.isVideo) {
            VideoPlayer(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                videoUri = pixaItemInfo.url
            )
        } else {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = pixaItemInfo.url.toUri(),
                contentScale = ContentScale.Crop,
                contentDescription = "item image"
            )
        }

        PixaItemInfoHeader(
            userName = pixaItemInfo.userName,
            isLike = pixaItemInfo.isLike,
            onClickLike = { action(ContentDetailIntent.OnToggleLike) }
        )
        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            InfoItem(
                label = "Type",
                value = pixaItemInfo.itemType
            )
            InfoItem(
                label = "Views",
                value = pixaItemInfo.views.toString()
            )
            InfoItem(
                label = "Likes",
                value = pixaItemInfo.likes.toString()
            )
            InfoItem(
                label = "Downloads",
                value = pixaItemInfo.downloads.toString()
            )
        }
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Tags",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            text = pixaItemInfo.tags.joinToString(" • ")
        )
    }
}

@ThemePreview
@Composable
private fun ContentDetailContentPreview() {
    ContentDetailContent(
        pixaItemInfo = DEFAULT_IMAGE_INFO,
        action = {}
    )
}
