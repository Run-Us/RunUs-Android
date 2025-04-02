package com.teamrunus.runus.ui.components.main_page

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamrunus.runus.R

// 서버에서 코멘트까지 받아도 됨. (확장성)
const val NEW_RUNIMO_COMMENT = "새로운 동물이 태어났어요!"
const val EXISTING_RUNIMO_COMMENT = "익숙한 친구를 만났어요..."

@Composable
fun EggHatchingModal(
    onConfirmClick: () -> Unit,
    onDismiss: () -> Unit
) {
    val gatchaResult by remember { mutableStateOf(loadGatchaResult()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { ModalTitle(gatchaResult) },
        text = { ModalContent(gatchaResult) },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onConfirmClick,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = if (gatchaResult.alreadyHave) "대표 캐릭터로 설정하기" else "확인")
                }
            }
        }
    )
}

@Composable
fun ModalTitle(gatchaResult: GatchaResult) {
    Text(
        text = if (gatchaResult.alreadyHave) EXISTING_RUNIMO_COMMENT else NEW_RUNIMO_COMMENT,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun ModalContent(gatchaResult: GatchaResult) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "[${gatchaResult.name}]: ${gatchaResult.description}",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.rabbit),
            contentDescription = gatchaResult.name,
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp),
            tint = Color.Unspecified
        )
    }
}

fun loadGatchaResult(): GatchaResult =
    GatchaResult(
        name = "토끼",
        description = "안녕 톼끼",
        imgUrl = "토끼url",
        alreadyHave = true
    )

/**
 * 뽑기에서 나온 러니모 정보
 * - 러니모 정보
 * - 중복 여부
 */
data class GatchaResult(
    val name: String,
    val description: String,
    val imgUrl: String,
    val alreadyHave: Boolean
)
