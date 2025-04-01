package com.teamrunus.runus.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teamrunus.runus.R
import com.teamrunus.runus.ui.components.character_collection_page.CharacterCard
import com.teamrunus.runus.ui.components.character_collection_page.CharacterCollectionTopBar
import com.teamrunus.runus.ui.components.character_collection_page.CharacterDetailModal
import com.teamrunus.runus.ui.theme.RunUsTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterScreen(navController: NavHostController) {
    var selectedCharacter by remember { mutableStateOf<CharacterData?>(null) }
    var userRunimoData by remember { mutableStateOf(UserRunimoData(29900, emptyList())) }
    Scaffold(
        topBar = {
            CharacterCollectionTopBar(
                title = "캐릭터",
                distance = "${(userRunimoData.totalRunningDistanceInMeters / 1000)} Km",
                navController = navController
            )
        }
    ) {
        paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(characterGroups) { group ->
                        CharacterGroupCard(
                            groupName = group.groupName,
                            characters = group.characters,
                            onCharacterClick = { character ->
                                selectedCharacter = character
                            }
                        )
                    }
                }
            }
        selectedCharacter?.let { character ->
            CharacterDetailModal(
                character = character,
                onDismiss = { selectedCharacter = null }
            )
        }

    }
}

@Composable
fun CharacterGroupCard(groupName: String, characters: List<CharacterData>, onCharacterClick: (CharacterData) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = groupName,
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        for (row in characters.chunked(2)) {
            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { character ->
                    CharacterCard (
                        name = character.name,
                        imageRes = character.imageRes,
                        onClick = { onCharacterClick(character) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

data class UserRunimoData(
    val totalRunningDistanceInMeters: Long,
    val unLockedRunimos: List<CharacterData>
)
data class CharacterData(val name: String, val imageRes: Int)
data class CharacterGroup(val groupName: String, val characters: List<CharacterData>)

val characterGroups = listOf(
    CharacterGroup(
        groupName = "마당 알",
        characters = listOf(
            CharacterData("강아지", R.drawable.dog),
            CharacterData("고양이", R.drawable.wolf),
            CharacterData("토끼", R.drawable.rabbit),
            CharacterData("오리", R.drawable.duck)
        )
    ),
    CharacterGroup(
        groupName = "숲속 알",
        characters = listOf(
            CharacterData("여우", R.drawable.dog),
            CharacterData("곰", R.drawable.carrot),
            CharacterData("사슴", R.drawable.duck),
            CharacterData("늑대", R.drawable.wolf)
        )
    )
)

@Preview(showBackground = true, name = "Character Screen Preview")
@Composable
fun CharacterScreenPreview() {
    val navController = rememberNavController()
    RunUsTheme {
        CharacterScreen(navController)
    }
}
