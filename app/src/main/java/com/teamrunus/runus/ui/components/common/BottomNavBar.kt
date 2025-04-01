package com.teamrunus.runus.ui.components.common


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Gray
    ) {
        listOf("main", "World", "character", "Profile").forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = getIcon(item)),
                        contentDescription = item
                    )
                },
                label = { Text(item) },
                selected = false,
                onClick = { navController.navigate(item) }
            )
        }
    }
}

fun getIcon(item: String): Int {
    return when (item) {
        "main" -> android.R.drawable.ic_menu_compass
        "Run" -> android.R.drawable.ic_menu_directions
        "Profile" -> android.R.drawable.ic_menu_myplaces
        else -> android.R.drawable.ic_menu_help
    }
}
