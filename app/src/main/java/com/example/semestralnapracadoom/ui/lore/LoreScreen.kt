package com.example.semestralnapracadoom.ui.lore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.R
import com.example.semestralnapracadoom.ui.monsters.Monster
import com.example.semestralnapracadoom.ui.quiz.QuizViewModel

@Composable
fun LoreScreen(
    navController: NavController,
    viewModel: LoreViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    var showEP1Dialog by remember { mutableStateOf(false) }
    var showEP2Dialog by remember { mutableStateOf(false) }
    var showEP3Dialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Red , Color.Blue) ,
                    center = Offset(1080f , 1920f) , // center of the gradient
                    radius = 1500f + uiState.value // radius of the gradient
                )
            )
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Lore Of DOOM",
                fontWeight = FontWeight.Bold,
                style = typography.titleLarge,
                modifier = Modifier.padding(30.dp)
            )
            LazyColumn(
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = stringResource(R.string.lore_1) ,
                        style = typography.bodyLarge,
                        textAlign = TextAlign.Justify,
                        color = Color.White,
                        modifier = Modifier
                            .padding(40.dp , 20.dp)
                            .background(Color.Red.copy(alpha = 0.1f))
                    )
                }
                item {
                    Image(
                        painter = painterResource(id = R.drawable.cyber_demon0),
                        contentDescription = null,
                        Modifier.size(500.dp))
                }
                item {
                    Text(
                        text = stringResource(R.string.lore_2) ,
                        style = typography.bodyLarge,
                        textAlign = TextAlign.Justify,
                        color = Color.White,
                        modifier = Modifier
                            .padding(40.dp , 20.dp)
                            .background(Color.Red.copy(alpha = 0.1f))
                    )
                }
                item {
                    Image(
                        painter = painterResource(id = R.drawable.lost_soul0),
                        contentDescription = null,
                        Modifier.size(250.dp))
                }
                item {
                    Text(
                        text = stringResource(R.string.lore_3) ,
                        style = typography.bodyLarge,
                        textAlign = TextAlign.Justify,
                        color = Color.White,
                        modifier = Modifier
                            .padding(40.dp , 20.dp)
                            .background(Color.Red.copy(alpha = 0.1f))
                    )
                }
                item {
                    Button(
                        elevation = ButtonDefaults.buttonElevation(8.dp),
                        onClick = { showEP3Dialog = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp , 5.dp)
                    ) {
                        Text(text = "Knee-Deep in the Dead")
                    }
                    if (showEP1Dialog) {
                        EpisodeDialog(
                            nameOfEpisode = "Knee-Deep in the Dead" ,
                            first = "Hangar",
                            second = "Nuclear Plant",
                            third =  "Toxin Refinery",
                            fourth = "Command Control" ,
                            fifth = "Phobos Lab" ,
                            sixth = "Central Processing" ,
                            seventh = "Computer Station" ,
                            eigth = "Phobos Anomaly",
                            {showEP1Dialog = false}
                        )
                    }
                }
                item {
                    Button(
                        elevation = ButtonDefaults.buttonElevation(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp , 5.dp),
                        onClick = { showEP2Dialog = true }
                    ) {
                        Text(text = "The Shores of Hell")
                    }
                    if (showEP2Dialog) {
                        EpisodeDialog(
                            nameOfEpisode = "The Shores of Hell" ,
                            first = "Deimos Anomaly",
                            second = "Containment Area",
                            third =  "Refinery",
                            fourth = "Deimos Lab" ,
                            fifth = "Command Center" ,
                            sixth = "Halls of the Damned" ,
                            seventh = "Spawning Vats" ,
                            eigth = "Tower of Babel",
                            {showEP2Dialog = false}
                        )
                    }
                }
                item {
                    Button(
                        elevation = ButtonDefaults.buttonElevation(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp , 5.dp),
                        onClick = { showEP3Dialog = true }
                    ) {
                        Text(text = "Inferno")
                    }
                    if (showEP3Dialog) {
                        EpisodeDialog(
                            nameOfEpisode = "Inferno" ,
                            first = "Hell Keep",
                            second = "Slough of Despair",
                            third =  "Pandemonium",
                            fourth = "House of Pain" ,
                            fifth = "Unholy Cathedral" ,
                            sixth = "Mt. Erebus" ,
                            seventh = "Limbo" ,
                            eigth = "Dis",
                            {showEP3Dialog = false}
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.size(50.dp))
                }
            }
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Back!")
        }
    }
}

@Composable
private fun EpisodeDialog(
    nameOfEpisode: String,
    first: String,
    second: String,
    third: String,
    fourth: String,
    fifth: String,
    sixth: String,
    seventh: String,
    eigth: String,
    onClose: () -> Unit
) {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = { Text(text = nameOfEpisode,
                fontWeight = FontWeight.Bold) },
            text = { Text(text =
                    "1: $first\n" +
                    "2: $second\n" +
                    "3: $third\n" +
                    "4: $fourth\n" +
                    "5: $fifth\n" +
                    "6: $sixth\n" +
                    "7: $seventh\n" +
                    "8: $eigth") },
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




@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun LoreScreenPreview() {
    LoreScreen(navController = rememberNavController())
}