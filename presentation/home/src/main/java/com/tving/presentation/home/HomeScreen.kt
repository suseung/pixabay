package com.tving.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tving.designsystem.component.TvingScaffold
import com.tving.presentation.common.component.CommonBottomBar
import com.tving.presentation.home.component.ImageCard
import com.tving.presentation.home.component.VideoPlayer
import com.tving.presentation.home.component.SearchBar
import com.tving.presentation.model.ImageInfoUiModel
import com.tving.presentation.model.VideoInfoUiModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToFavorite: () -> Unit = {}
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val action by remember { mutableStateOf(viewModel::dispatch) }

    TvingScaffold(
        titleContent = {
            Text("Home")
        },
        bottomBar = {
            CommonBottomBar(
                onNavigateToFavorite = onNavigateToFavorite
            )
        }
    ) { paddingValues ->
        (uiState as? HomeState.Success)?.let {
            HomeContent(
                modifier = Modifier.padding(paddingValues),
                input = it.input,
                videoInfo = it.videoInfo,
                imageInfos = it.images,
                action = action
            )
        }

    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    input: String,
    videoInfo: VideoInfoUiModel,
    imageInfos: List<ImageInfoUiModel>,
    action: (HomeIntent) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {
        item {
            SearchBar(
                modifier = Modifier,
                input = input,
                onInputChange = { action(HomeIntent.OnChangeInput(it)) },
                onClickClear = { action(HomeIntent.OnClearInput) }
            )
        }
        if (input.isEmpty()) {
            item {
                Icon(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(100.dp),
                    imageVector = ImageVector.vectorResource(com.tving.designsystem.R.drawable.ic_arrow_back),
                    tint = Color.Unspecified,
                    contentDescription = "search button"
                )
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Search for video and images"
                )
            }
        } else {
            if (videoInfo.url.isNotEmpty()) {
                item {
                    VideoPlayer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        videoUri = videoInfo.url
                    )
                }
            }
            if (imageInfos.isNotEmpty()) {
                items(imageInfos.chunked(2)) { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        for (item in rowItems) {
                            ImageCard(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f),
                                imageInfo = item
                            )
                        }
                        if (rowItems.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}
