package com.teamrunus.runus.ui.components.main_page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamrunus.runus.R

@Composable
fun MainPageProfileCard(userData: MainPageUserData,
                        onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick)  // 클릭 이벤트 추가
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.dog_character),
                contentDescription = "Character",
                modifier = Modifier.size(96.dp),
                tint = Color.Unspecified

            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(userData.nickname, fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
                Row (
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text("러닝", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface, )
                        Text(userData.totalRunningCount.toString(), fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface)
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Column{
                        Text("달린 거리", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
                        Text(String.format("%.2f Km", parseToKiloMeters(userData.totalRunningDistanceInMeters)), fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }
        }
    }
}



fun parseToKiloMeters(totalDistanceInMeters: Long): Double {
    return totalDistanceInMeters.div(1000.0)
}

data class MainPageUserData(
    val nickname: String,
    val totalRunningCount: Long,
    val totalRunningDistanceInMeters:Long,
) {

}
