package com.example.semestralnapracadoom.ui.monsters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.ui.mainMenu.MainMenuViewModel

@Composable
fun MonstersMain(
    navController: NavController,
    viewModel: MonstersViewModel = viewModel()
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Monsters" ,
            style = typography.titleMedium ,
            modifier = Modifier
                .padding(20.dp)
        )
        LazyColumn (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .weight(1f)
        ) {
            items(viewModel.monsters) {monster ->
                ShowMonster(monster = monster)
            }
        }
        Button(
            onClick = { navController.navigate("main_menu") },
            ) {
            Text(
                text = "Back"
            )
        }
        //ShowMonster(monster = viewModel.monsters[0])
    }
}


@Composable
fun ShowMonster(monster: Monster) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(id = monster.imageResId),
                contentDescription = monster.description ,
                modifier = Modifier
                    .size(150.dp)
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }
        Text(
            textAlign = TextAlign.Center,
            text = monster.name,
            style = typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            textAlign = TextAlign.Center,
            text = monster.description,
            style = typography.bodyLarge
        )
    }
}

@Composable
fun MonsterDescription(monster: Monster) {
    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
        },
        title = { Text(text = monster.name) },
        text = { Text(text = monster.description) },
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "OK")
            }
        }
    )
}

@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewMonsters() {
    MonstersMain(navController = rememberNavController())
}