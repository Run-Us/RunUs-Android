package com.teamrunus.runus.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.teamrunus.runus.ui.components.common.BottomNavBar
import com.teamrunus.runus.ui.components.main_page.MainPageProfileCard
import com.teamrunus.runus.ui.components.main_page.EggCard
import com.teamrunus.runus.ui.components.main_page.EggInfo
import com.teamrunus.runus.ui.components.main_page.EggRegisterModal
import com.teamrunus.runus.ui.components.main_page.Header
import com.teamrunus.runus.ui.components.main_page.MainPageUserData

@Composable
fun MainScreen(navController: NavHostController) {
    val data = loadMainPageData()
    var showModal by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { Header(lovePoints = data.lovePoint, eggCount = data.totalEggCount) },
        bottomBar = { BottomNavBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            MainPageProfileCard(
                MainPageUserData(
                    nickname = data.nickname,
                    totalRunningCount = data.totalRunningCount,
                    totalRunningDistanceInMeters = data.totalDistanceInMeters
                ),
                onClick = { navController.navigate("character") } // 클릭 시 이동
            )
            Spacer(modifier = Modifier.height(16.dp))
            EggCard(
                eggInfo = EggInfo(
                    hasEgg = data.hasIncubatingEgg,
                    eggName = "마당 알",
                    currentLovePoint = 10,
                    requiredLovePoint = 10,
                    isReadyToHatch = true
                ),
                onRegisterClick = { showModal = true },
                onLoveClick = { println("애정 주기 실행") },
                onHatchClick = { println("부화하기 실행") }
            )
            if (showModal) {
                EggRegisterModal(
                    onDismiss = { showModal = false },
                    onSelectEgg = { selectedEgg ->
                        println("선택한 알: $selectedEgg")
                        showModal = false
                    }
                )
            }
        }
    }
}

fun loadMainPageData(): MainPageData {
    return MainPageData(
        nickname = "러니모",
        profileImgUrl = "hi.ulr",
        lovePoint = 10,
        totalDistanceInMeters = 1203,
        totalRunningCount = 1,
        totalEggCount = 1,
        hasIncubatingEgg = true
    )
}

data class MainPageData(
    val nickname: String,
    val profileImgUrl: String,
    val lovePoint: Long,
    val totalDistanceInMeters: Long,
    val totalRunningCount: Long,
    val totalEggCount: Long,
    val hasIncubatingEgg: Boolean,
)