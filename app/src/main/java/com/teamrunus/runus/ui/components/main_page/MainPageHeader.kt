package com.teamrunus.runus.ui.components.main_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.teamrunus.runus.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    logoRes: Int = R.drawable.main_logo,  // 로고 이미지 파일 리소스
    lovePoints: Long = 12,
    eggCount: Long = 2
) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = logoRes),
                contentDescription = "App Logo",
                modifier = Modifier
                    .height(40.dp)
                    .padding(4.dp)
            )
        },
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 15.dp)

            ) {
                IconWithCount(
                    iconRes = R.drawable.ic_egg,
                    count = eggCount,
                    description = "Egg Count"
                )
                Spacer(modifier = Modifier.width(16.dp))
                IconWithCount(
                    iconRes = R.drawable.ic_heart,
                    count = lovePoints,
                    description = "Love Points"
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            scrolledContainerColor = Color.LightGray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RectangleShape
            )
            .padding(bottom = 1.dp)
    )
}

@Composable
fun IconWithCount(iconRes: Int, count: Long, description: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = description,
            modifier = Modifier.size(24.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = count.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}