package com.teamrunus.runus.ui.components.character_collection_page

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import com.teamrunus.runus.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCollectionTopBar(
    title: String,
    distance: String,
    navController: NavHostController
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = distance,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(R.drawable.ic_egg),
                    contentDescription = "Back",
                    tint = Color.Unspecified
                )
            }
        }
    )
}
