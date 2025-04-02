package com.teamrunus.runus.ui.components.main_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamrunus.runus.R

data class EggInfo(
    val hasEgg: Boolean = false,
    val eggName: String,
    val currentLovePoint: Long = 0,
    val requiredLovePoint: Long = 0,
    val isReadyToHatch: Boolean = false
)

@Composable
fun EggCard(
    eggInfo: EggInfo,
    onRegisterClick: () -> Unit,
    onLoveClick: () -> Unit,
    onHatchClick: () -> Unit
) {
    var showHatchingModal by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (eggInfo.hasEgg) {
                EggContent(eggInfo)
                EggActionButton(
                    isReadyToHatch = eggInfo.isReadyToHatch,
                    onLoveClick = onLoveClick,
                    onHatchClick = {
                        showHatchingModal = true
                        onHatchClick()
                    }
                )
                if (showHatchingModal) {
                    EggHatchingModal(
                        onConfirmClick = { showHatchingModal = false },
                        onDismiss = { showHatchingModal = false }
                    )
                }
            } else {
                EmptyEggContent(onRegisterClick)
            }
        }
    }
}

@Composable
fun EggContent(eggInfo: EggInfo) {
    Image(
        painter = painterResource(id = R.drawable.egg),
        contentDescription = "Egg",
        modifier = Modifier
            .size(256.dp)
            .padding(8.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = eggInfo.eggName,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.primary
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "${eggInfo.currentLovePoint}/${eggInfo.requiredLovePoint}",
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
fun EggActionButton(
    isReadyToHatch: Boolean,
    onLoveClick: () -> Unit,
    onHatchClick: () -> Unit
) {
    Button(
        onClick = { if (isReadyToHatch) onHatchClick() else onLoveClick() },
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(top = 8.dp)
    ) {
        Text(if (isReadyToHatch) "알 부화하기" else "애정 주기")
    }
}

@Composable
fun EmptyEggContent(onRegisterClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.empty_incubator),
        contentDescription = "Empty Incubator",
        modifier = Modifier
            .size(312.dp)
            .padding(8.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "새 알을 기다리는 중이에요",
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.onSurface
    )
    Spacer(modifier = Modifier.height(10.dp))
    Button(
        modifier = Modifier.fillMaxWidth(0.8f),
        onClick = onRegisterClick
    ) {
        Text("알 등록하기")
    }
}
