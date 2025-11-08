package com.tving.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
    ) {  paddingValues ->
        (uiState as? HomeState.Success)?.let {
            HomeContent(
                modifier = Modifier.padding(paddingValues),
                input = it.input,
                action = action
            )
        }

    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    input: String,
    action: (HomeIntent) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
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
        }
    }
}
