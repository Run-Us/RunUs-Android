package com.teamrunus.runus.ui.components.character_collection_page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 보유한 러니모 페이지(도감)에 리스트업되는 러니모 카드
 * 누르면 상세 정보로 이어짐.
 * TODO : 사용자 보유 현황에 따라 동적으로 노출 변경
 * */
@Composable
fun CharacterCard(name: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(140.dp)
            .height(180.dp)
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier.size(80.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = name, fontSize = 18.sp)
        }
    }
}
