package com.example.semestralnapracadoom.ui.IDSoftware

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.NavRoute
import com.example.semestralnapracadoom.R
import com.example.semestralnapracadoom.ui.common.ShowParagraph
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundViewModel

@Composable
fun IDSoftwareScreen(
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

    val config = LocalConfiguration.current
    val mode = remember { mutableStateOf(config.orientation) }
    var buttonPadding = 30.dp
    var titlePadding = 15.dp
    if (mode.value == Configuration.ORIENTATION_PORTRAIT) {
        buttonPadding = 80.dp
        titlePadding = 50.dp
    }

    val uiState by glowingBackgroundViewModel.uiState.collectAsState()
    Box {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = stringResource(R.string.idSoftware_title) ,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(15.dp, titlePadding, 15.dp, 15.dp),
                color = Color.White,
                fontSize = 30.sp
            )
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ShowParagraph(
                        title = stringResource( R.string.idSoftware_P1_title ) ,
                        text = stringResource( R.string.idSoftware_P1_body )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp),
                        painter = painterResource(
                            id = R.drawable.id_software_logo),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = "" , text = stringResource(R.string.idSoftware_P2_body))
                }
                item { 
                    ShowParagraph(title = "" , text = stringResource(R.string.idSoftware_P3_body))
                }
                item {
                    Row(
                        modifier = Modifier
                            .padding(25.dp)
                            .size(250.dp , 150.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.commander_keen) ,
                            contentDescription = null,
                            modifier = Modifier.size(125.dp, 150.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.quake_logo) ,
                            contentDescription = null,
                            modifier = Modifier.size(150.dp)
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.size(110.dp))
                }
            }
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(buttonPadding),
            onClick = { navController.navigate(NavRoute.MAIN_MENU.route) }
        ) {
            Text(text = stringResource(id = R.string.BackButton_text))
        }
    }
}


@Preview (
    showSystemUi = true,
    showBackground = true
)
@Composable
fun IDSoftwareScreenPreview() {
    IDSoftwareScreen(navController = rememberNavController())
}