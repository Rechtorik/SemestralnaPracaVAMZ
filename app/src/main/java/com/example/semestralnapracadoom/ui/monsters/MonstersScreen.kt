package com.example.semestralnapracadoom.ui.monsters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun MonstersMain(
    navController: NavController,
    viewModel: MonstersViewModel = viewModel()
) {
    Box {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Monsters" ,
                style = typography.titleLarge,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(20.dp)
            )
            LazyColumn (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(viewModel.monsters) {monster ->
                    ShowMonster(monster = monster)
                }
            }
        }
        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { navController.navigate("main_menu") },
        ) {
            Text(
                text = "Back"
            )
        }
    }
}


@Composable
fun ShowMonster(monster: Monster) {
    var showMonsterDialog by remember { mutableStateOf(false) }
    var image by remember { mutableStateOf(monster.imageResId) }

    LaunchedEffect(true) {
        while (true) {
            delay(250) // Počkáme 250 milisekúnd
            image = monster.imageResId
        }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(30.dp)
    ) {
        TextButton(
            onClick = { showMonsterDialog = true }
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = monster.description ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }
        Text(
            textAlign = TextAlign.Center,
            text = monster.name,
            style = typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }
    if (showMonsterDialog) {
        MonsterDialog(monster = monster, onClose = { showMonsterDialog = false })
    }
}

@Composable
private fun MonsterDialog(
    monster: Monster,
    onClose: () -> Unit
) {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {

            },
            title = { Text(text = monster.name,
                fontWeight = FontWeight.Bold) },
            text = { Text(text = monster.description) },
            confirmButton = {
                TextButton(onClick = {
                    onClose()
                    showDialog = false
                }) {
                    Text(text = "OK")
                }
            }
        )
    }
}






@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewMonsters() {
    MonstersMain(navController = rememberNavController())
}