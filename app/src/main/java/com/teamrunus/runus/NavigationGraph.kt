package com.teamrunus.runus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teamrunus.runus.screens.CharacterScreen
import com.teamrunus.runus.screens.MainScreen

@Composable
fun Navigationgraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") { MainScreen(navController) }
        composable("character") { CharacterScreen(navController) }
    }
}