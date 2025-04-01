package com.teamrunus.runus.ui.components.character_collection_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamrunus.runus.screens.CharacterData

/***
 * 도감 화면에서 캐릭터 누르면 올라오는 모달창
 * TODO: 캐릭터 누르면 사용자와 러니모간의 데이터 조회해야함.
 * eg. 이 러니모와 달린 횟수, 거리
 * @param CharacterData 캐릭터 데이터(static)
 */

@Composable
fun CharacterDetailModal(character: CharacterData, onDismiss: () -> Unit) {
    val runimoDetail = loadUserRunimoData()
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = "[${character.name}]",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "[간략한 설명]",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        },
        text = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Icon(
                    painter = painterResource(id = character.imageRes),
                    contentDescription = character.name,
                    modifier = Modifier.size(200.dp),
                    tint = Color.Unspecified

                )
                Row (
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(text = "러닝 횟수: ${runimoDetail.runningCount}")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "달린 거리: ${runimoDetail.totalRunningDistanceInMeters} km")
                }
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                ){
                    Button(onClick = onDismiss) {
                        Text("설정하기")
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Button(onClick = onDismiss) {
                        Text("취소")
                    }
                }
            }
        },
        confirmButton = {
        },
        dismissButton = {

        }
    )
}
fun loadUserRunimoData(): UserRunimoData {
    return UserRunimoData(
        name = "example",
        description = "this is example",
        runningCount = 2,
        totalRunningDistanceInMeters = 10000
    )
}

// 사용자마다 특정 러니모와 달린 기록이 다름.
data class UserRunimoData (
    val name: String,
    val description: String,
    val runningCount: Long,
    val totalRunningDistanceInMeters: Long
)
{
}