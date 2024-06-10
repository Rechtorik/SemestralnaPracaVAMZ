package com.example.semestralnapracadoom.ui.myPlay

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.NavRoute
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundUiState
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundViewModel
import kotlin.math.round

@Composable
fun MyPlayScreen(
    navController: NavController,
    myPlayViewModel: MyPlaylViewModel,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
) {
    val myPlayUiState by myPlayViewModel.uiState.collectAsState()
    val glowingBackgroundUiState by glowingBackgroundViewModel.uiState.collectAsState()

    val config = LocalConfiguration.current
    val mode = remember { mutableStateOf(config.orientation) }

    if (mode.value == Configuration.ORIENTATION_PORTRAIT) {
        MyPlayScreenPortrait(
            navController = navController,
            myPlayUiState = myPlayUiState,
            myPlayViewModel = myPlayViewModel,
            glowingBackgroundUiState = glowingBackgroundUiState,
        )
    } else {
        MyPlayScreenLandscape(
            navController = navController,
            myPlayUiState = myPlayUiState,
            myPlayViewModel = myPlayViewModel,
            glowingBackgroundUiState = glowingBackgroundUiState,
        )
    }


}

@Composable
fun MyPlayScreenPortrait(
    navController: NavController,
    myPlayViewModel: MyPlaylViewModel,
    myPlayUiState: MyPlayUiState,
    glowingBackgroundUiState: GlowingBackgroundUiState,
) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(ColorBG1, ColorBG2) ,
                    center = Offset(1080f , 1920f) , // center of the gradient
                    radius = 1500f + glowingBackgroundUiState.value // radius of the gradient
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "My Play" ,
                style = typography.titleLarge ,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                color = Color.White,
                modifier = Modifier.padding(30.dp)
            )
            Text(
                text = "Progress: ${round((myPlayUiState.level.position / 24.toFloat())*100).toInt()}%",
                style = typography.titleLarge,
                color = Color.White
            )
            LinearProgressIndicator(
                progress = (myPlayUiState.level.position / 24.toFloat()),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(40.dp , 5.dp , 40.dp , 20.dp),
                color = Color.Red
            )
            Text(
                text = "Currently on: ",
                color = Color.White
            )
            Text(
                text = myPlayUiState.level.name,
                color = Color.White,
                style = typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(60.dp, 5.dp),
                onClick = {
                    myPlayUiState.level.note = myPlayUiState.note
                    myPlayViewModel.setNote("")
                    myPlayViewModel.NextLevel()
                }) {
                Text(text = "Finish Level!")
            }
            Text(
                text = "Notes:",
                color = Color.White
            )
            TextField(
                value = myPlayUiState.note ,
                onValueChange = { myPlayViewModel.setNote(it) },
                modifier = Modifier
                    .height(250.dp)
                    .padding(20.dp)
            )
            Button(
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(60.dp, 5.dp),
                onClick = {
                    myPlayUiState.level.note = myPlayUiState.note
                    navController.navigate(NavRoute.MY_PLAY_NOTES.route)
                }
            ) {
                Text(text = "All notes")
            }
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = {
                myPlayUiState.level.note = myPlayUiState.note
                navController.navigate(NavRoute.MAIN_MENU.route)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(80.dp)
        ) {
            Text(text = "Back")
        }
    }
}

@Composable
fun MyPlayScreenLandscape(
    navController: NavController,
    myPlayViewModel: MyPlaylViewModel,
    myPlayUiState: MyPlayUiState,
    glowingBackgroundUiState: GlowingBackgroundUiState,
) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(ColorBG1, ColorBG2) ,
                    center = Offset(1920f , 1080f) , // center of the gradient
                    radius = 1500f + glowingBackgroundUiState.value // radius of the gradient
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Row (
            modifier = Modifier.fillMaxSize()
        ) {
            Column (
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "My Play" ,
                    style = typography.titleLarge ,
                    fontWeight = FontWeight.Bold,
                    fontSize = 60.sp,
                    color = Color.White,
                    modifier = Modifier.padding(30.dp)
                )
                Text(
                    text = "Progress: ${round((myPlayUiState.level.position / 24.toFloat())*100).toInt()}%",
                    style = typography.titleLarge,
                    color = Color.White
                )
                LinearProgressIndicator(
                    progress = (myPlayUiState.level.position / 24.toFloat()),
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .padding(40.dp , 5.dp , 40.dp , 20.dp),
                    color = Color.Red
                )
                Text(
                    text = "Currently on: ",
                    color = Color.White
                )
                Text(
                    text = myPlayUiState.level.name,
                    color = Color.White,
                    style = typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                )
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    onClick = {
                        myPlayUiState.level.note = myPlayUiState.note
                        navController.navigate(NavRoute.MAIN_MENU.route)
                    },
                    modifier = Modifier
                        .padding(30.dp)
                ) {
                    Text(text = "Back")
                }
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier.padding(20.dp, 50.dp, 20.dp, 20.dp),
                    text = "Notes:",
                    color = Color.White
                )
                TextField(
                    value = myPlayUiState.note ,
                    onValueChange = { myPlayViewModel.setNote(it) },
                    modifier = Modifier
                        .height(200.dp)
                        .padding(5.dp)
                )
                Row (
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        elevation = ButtonDefaults.buttonElevation(8.dp),
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(5.dp),
                        onClick = {
                            myPlayUiState.level.note = myPlayUiState.note
                            navController.navigate(NavRoute.MY_PLAY_NOTES.route)
                        }
                    ) {
                        Text(text = "All notes")
                    }
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(5.dp),
                        onClick = {
                            myPlayUiState.level.note = myPlayUiState.note
                            myPlayViewModel.setNote("")
                        myPlayViewModel.NextLevel()
                    }) {
                        Text(text = "Finish Level!")
                    }
                }
            }
        }
    }
}






@Preview (
    showSystemUi = true,
    showBackground = true
)
@Composable
fun MyPlayScreenPreview() {
    MyPlayScreen(
        navController = rememberNavController(),
        myPlayViewModel = viewModel())
}