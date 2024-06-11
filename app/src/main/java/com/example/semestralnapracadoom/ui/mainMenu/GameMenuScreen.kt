package com.example.semestralnapracadoom.ui.mainMenu

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.NavRoute
import com.example.semestralnapracadoom.R
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundViewModel

@Composable
fun MainMenuScreen(navController: NavController,) {
    val config = LocalConfiguration.current
    val mode = remember { mutableStateOf(config.orientation) }
    if (mode.value == Configuration.ORIENTATION_PORTRAIT) {
        MainMenuScreenPortrait(navController = navController)
    } else {
        MainMenuScreenLandscape(navController = navController)
    }
}




@Composable
fun MainMenuScreenPortrait (
    navController: NavController,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
    ) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(ColorBG1 , ColorBG2) ,
                    center = Offset(1080f , 1920f) , // center of the gradient
                    radius = 2200f + uiState.value // radius of the gradient
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.a_doom_logo) ,
            contentDescription = "MainMenuLogo",
            modifier = Modifier
                .size(400.dp , 300.dp)
                .padding(20.dp , 40.dp)
        )
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp , 0.dp) ,
                onClick = { navController.navigate(NavRoute.MY_PLAY.route) }
            ) {
                Text(stringResource(R.string.menu_myPlay))
            }
            Button(
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp , 0.dp) ,
                onClick = { navController.navigate(NavRoute.LORE.route) }
            ) {
                Text(stringResource(R.string.menu_lore))
            }
            Button(
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp , 0.dp) ,
                onClick = { navController.navigate(NavRoute.MONSTERS.route) }
            ) {
                Text(stringResource(R.string.menu_monsters))
            }
            Button(
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp , 0.dp) ,
                onClick = { navController.navigate(NavRoute.ID_SOFTWARE.route) }
            ) {
                Text(stringResource(R.string.menu_idSoftware))
            }
            Button(
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp , 0.dp) ,
                onClick = { navController.navigate(NavRoute.INTERESTING_FACTS.route) }
            ) {
                Text(stringResource(R.string.menu_interestingFacts))
            }
            Button(
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp , 0.dp) ,
                onClick = { navController.navigate(NavRoute.QUIZ.route) }
            ) {
                Text(stringResource(R.string.menu_quiz))
            }
        }
    }
}

@Composable
fun MainMenuScreenLandscape(
    navController: NavController,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(ColorBG1 , ColorBG2) ,
                    center = Offset(1920f , 1080f) , // center of the gradient
                    radius = 2200f + uiState.value // radius of the gradient
                )
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.a_doom_logo) ,
            contentDescription = "MainMenuLogo",
            modifier = Modifier
                .size(200.dp , 150.dp)
                .padding(20.dp)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp , 0.dp)
        ) {
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate(NavRoute.MY_PLAY.route) }
                ) {
                    Text("MY PLAY")
                }
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate(NavRoute.LORE.route) }
                ) {
                    Text("LORE")
                }
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate(NavRoute.MONSTERS.route) }
                ) {
                    Text("MONSTERS")
                }
            }
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate(NavRoute.ID_SOFTWARE.route) }
                ) {
                    Text("ID SOFTWARE")
                }
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate(NavRoute.INTERESTING_FACTS.route) }
                ) {
                    Text("INTERESTING FACTS")
                }
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate(NavRoute.QUIZ.route) }
                ) {
                    Text("QUIZ")
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun MainMenuPreview() {
    MainMenuScreen(navController = rememberNavController())
}
