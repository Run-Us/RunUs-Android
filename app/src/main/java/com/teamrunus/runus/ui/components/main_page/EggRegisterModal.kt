package com.teamrunus.runus.ui.components.main_page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamrunus.runus.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EggRegisterModal(
    onDismiss: () -> Unit,
    onSelectEgg: (String) -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        Text(
            text = "다음 알을 부화시킬 차례에요",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        ListItem(
            headlineContent = { Text("마당 알") },
            leadingContent = {
                Icon(
                    painter = painterResource(id = R.drawable.egg),
                    contentDescription = "Egg Icon",
                    modifier = Modifier.size(40.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable {
                    coroutineScope.launch {
                        onSelectEgg("마당 알")
                        onDismiss()
                    }
                }
        )
    }
}
