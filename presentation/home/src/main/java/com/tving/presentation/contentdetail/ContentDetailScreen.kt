package com.tving.presentation.contentdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import com.tving.presentation.contentdetail.component.ImageInfoHeader
import com.tving.presentation.contentdetail.component.InfoItem
import com.tving.presentation.model.DEFAULT_IMAGE_INFO
import com.tving.presentation.model.ImageInfoUiModel

@Composable
fun ContentDetailScreen(
    viewModel: ContentDetailViewModel = hiltViewModel(),
    onNavigateToHome: () -> Unit = {}
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
        }
    ) { paddingValues ->
        ContentDetailContent(
            modifier = Modifier.padding(paddingValues),
            imageInfo = uiState.imageInfo,
            action = action
        )
    }
}

@Composable
fun ContentDetailContent(
    modifier: Modifier = Modifier,
    imageInfo: ImageInfoUiModel,
    action: (ContentDetailIntent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = imageInfo.imageUrl.toUri(),
            contentScale = ContentScale.Fit,
            contentDescription = "item image"
        )
        ImageInfoHeader(
            title = imageInfo.title,
            isLike = imageInfo.isLike,
            onClickLike = { action(ContentDetailIntent.OnToggleLike) }
        )
        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            InfoItem(
                label = "Type",
                value = imageInfo.type
            )
            InfoItem(
                label = "Views",
                value = imageInfo.views.toString()
            )
            InfoItem(
                label = "Likes",
                value = imageInfo.likes.toString()
            )
            InfoItem(
                label = "Downloads",
                value = imageInfo.downloads.toString()
            )
        }
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Tags",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = imageInfo.tagsToString
        )
    }
}

@ThemePreview
@Composable
private fun ContentDetailContentPreview() {
    ContentDetailContent(
        imageInfo = DEFAULT_IMAGE_INFO,
        action = {}
    )
}
