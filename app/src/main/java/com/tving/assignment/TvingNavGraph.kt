package com.tving.assignment

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tving.presentation.home.HomeScreen

object Destination {
    const val HOME = "home"
}

@Composable
fun TvingNavGraph(
    navController: NavHostController = rememberNavController()
) {
    val temp = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Destination.HOME
    ) {
        composable(Destination.HOME) {
            HomeScreen()
        }
    }
}
