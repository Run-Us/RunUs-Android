package com.teamrunus.runus.ui.components.main_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
    val requiredLovePoint: Long = 0
)

@Composable
fun EggCard(
    eggInfo: EggInfo,
    onRegisterClick: () -> Unit,
    onLoveClick: () -> Unit
) {
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
                // 부화 중인 알이 있을 때
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
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onLoveClick,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("애정 주기")
                }
            } else {
                // 부화 중인 알이 없을 때
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
        }
    }
}