package com.teamrunus.runus

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.teamrunus.runus.ui.components.common.BottomNavBar
import com.teamrunus.runus.ui.theme.RunUsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() // 전역 NavController
            RunUsTheme {
                Scaffold(
                    bottomBar = { BottomNavBar(navController) } // NavBar에서 동일한 NavController 사용
                ) {
                    Navigationgraph(navController) // NavGraph에 전달
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    RunUsTheme {
        Navigationgraph(navController)
    }
}