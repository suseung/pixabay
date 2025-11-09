package com.tving.assignment

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tving.assignment.Destination.CONTENT_DETAIL
import com.tving.assignment.Destination.HOME
import com.tving.presentation.contentdetail.ContentDetailScreen
import com.tving.presentation.home.HomeScreen
import com.tving.presentation.model.PixaUiModel
import com.tving.presentation.util.JsonUtil.pixaJson
import kotlinx.serialization.encodeToString

object Destination {
    const val HOME = "home"
    const val CONTENT_DETAIL = "content_detail"
}

@Composable
fun TvingNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HOME
    ) {
        composable(HOME) {
            HomeScreen(
                onNavigateToFavorite = {},
                onNavigateToContentDetail = { item ->
                    val data = Uri.encode(
                        pixaJson.encodeToString<PixaUiModel>(item)
                    )
                    navController.navigate("$CONTENT_DETAIL/$data")
                }
            )
        }
        composable(
            route = "$CONTENT_DETAIL/{item}",
            arguments = listOf(navArgument("item") { type = NavType.StringType } )
        ) {
            ContentDetailScreen(
                onNavigateToHome = {
                    navController.navigate(HOME)
                },
                onNavPopback = { navController.popBackStack() }
            )
        }
    }
}
