package com.tving.assignment

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tving.assignment.Destination.CONTENT_DETAIL
import com.tving.assignment.Destination.HOME
import com.tving.presentation.contentdetail.ContentDetailScreen
import com.tving.presentation.home.HomeScreen

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
                onNavigateToFavorite = {
                    navController.navigate(CONTENT_DETAIL)
                }
            )
        }
        composable(CONTENT_DETAIL) {
            ContentDetailScreen(
                onNavigateToHome = {
                    navController.navigate(HOME)
                }
            )
        }
    }
}
