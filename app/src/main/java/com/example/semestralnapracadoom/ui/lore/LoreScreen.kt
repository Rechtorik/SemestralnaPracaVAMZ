package com.example.semestralnapracadoom.ui.lore

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.NavRoute
import com.example.semestralnapracadoom.R
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundViewModel
import com.example.semestralnapracadoom.ui.quiz.QuizScreenLandscape
import com.example.semestralnapracadoom.ui.quiz.QuizScreenPortrait

@Composable
fun LoreScreen(
    navController: NavController,
    viewModel: GlowingBackgroundViewModel = viewModel()
) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    val uiState by viewModel.uiState.collectAsState()

    val config = LocalConfiguration.current
    val mode = remember { mutableStateOf(config.orientation) }
    var buttonPadding = 30.dp
    var titlePadding = 15.dp
    if (mode.value == Configuration.ORIENTATION_PORTRAIT) {
        buttonPadding = 80.dp
        titlePadding = 50.dp
    }

    var showEP1Dialog by remember { mutableStateOf(false) }
    var showEP2Dialog by remember { mutableStateOf(false) }
    var showEP3Dialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(ColorBG1 , ColorBG2) ,  // Color(0xFF562d7d) , Color(0xFF000000)
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
                text = stringResource(R.string.lore_title) ,
                fontWeight = FontWeight.Bold,
                style = typography.titleLarge,
                modifier = Modifier.padding(15.dp, titlePadding, 15.dp, 15.dp),
                color = Color.White,
                fontSize = 30.sp
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
                        onClick = { showEP1Dialog = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp , 5.dp)
                    ) {
                        Text(text = stringResource(R.string.lore_EP1))
                    }
                    if (showEP1Dialog) {
                        EpisodeDialog(
                            nameOfEpisode = stringResource(id = R.string.lore_EP1) ,
                            first = stringResource(R.string.lore_EP1_lvl1) ,
                            second = stringResource(R.string.lore_EP1_lvl2) ,
                            third = stringResource(R.string.lore_EP1_lvl3) ,
                            fourth = stringResource(R.string.lore_EP1_lvl4) ,
                            fifth = stringResource(R.string.lore_EP1_lvl5) ,
                            sixth = stringResource(R.string.lore_EP1_lvl6) ,
                            seventh = stringResource(R.string.lore_EP1_lvl7) ,
                            eigth = stringResource(R.string.lore_EP1_lvl8) ,
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
                        Text(text = stringResource(R.string.lore_EP2_title))
                    }
                    if (showEP2Dialog) {
                        EpisodeDialog(
                            nameOfEpisode = stringResource(id = R.string.lore_EP2_title) ,
                            first = stringResource(R.string.lore_EP2_lvl1) ,
                            second = stringResource(R.string.lore_EP2_lvl2) ,
                            third = stringResource(R.string.lore_EP2_lvl3) ,
                            fourth = stringResource(R.string.lore_EP2_lvl4) ,
                            fifth = stringResource(R.string.lore_EP2_lvl5) ,
                            sixth = stringResource(R.string.lore_EP2_lvl6) ,
                            seventh = stringResource(R.string.lore_EP2_lvl7) ,
                            eigth = stringResource(R.string.lore_EP2_lvl8) ,
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
                        Text(text = stringResource(R.string.lore_EP3_title))
                    }
                    if (showEP3Dialog) {
                        EpisodeDialog(
                            nameOfEpisode = stringResource(id = R.string.lore_EP3_title) ,
                            first = stringResource(R.string.lore_EP3_lvl1) ,
                            second = stringResource(R.string.lore_EP3_lvl2) ,
                            third = stringResource(R.string.lore_EP3_lvl3) ,
                            fourth = stringResource(R.string.lore_EP3_lvl4) ,
                            fifth = stringResource(R.string.lore_EP3_lvl5) ,
                            sixth = stringResource(R.string.lore_EP3_lvl6) ,
                            seventh = stringResource(R.string.lore_EP3_lvl7) ,
                            eigth = stringResource(R.string.lore_EP3_lvl8) ,
                            {showEP3Dialog = false}
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.size(130.dp))
                }
            }
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(buttonPadding)
        ) {
            Text(text = stringResource(id = R.string.BackButton_text))
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
        AlertDialog(
            onDismissRequest = {
                onClose()
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
                }) {
                    Text(text = "OK")
                }
            }
        )
}




@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun LoreScreenPreview() {
    LoreScreen(navController = rememberNavController())
}