package com.example.semestralnapracadoom.ui.interestingFacts

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
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
fun InterestingFactsScreen(
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
    val config = LocalConfiguration.current
    val mode = remember { mutableStateOf(config.orientation) }
    var buttonPadding = 30.dp
    var titlePadding = 15.dp
    if (mode.value == Configuration.ORIENTATION_PORTRAIT) {
        buttonPadding = 80.dp
        titlePadding = 50.dp
    }

    Box {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            ColorBG1 , ColorBG2
                        ) ,  // Color(0xFF562d7d) , Color(0xFF000000)
                        center = Offset(1080f , 1920f) , // center of the gradient
                        radius = 1500f + uiState.value // radius of the gradient
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = stringResource(R.string.interestingFacts_title) ,
                fontWeight = FontWeight.Bold,
                style = typography.titleLarge,
                modifier = Modifier.padding(15.dp, titlePadding, 15.dp, 15.dp),
                color = Color.White,
                fontSize = 30.sp
            )
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P1_title) , text = stringResource(
                        R.string.interestingFacts_P1_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 150.dp),
                        painter = painterResource(
                        id = R.drawable.interestingfactsimage1),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P2_title) , text = stringResource(
                        R.string.interestingFacts_P2_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfacts4_multiplayer),
                            contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P3_title) , text = stringResource(
                        R.string.interestingFacts_P3_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfactsimage2_billgates),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P4_title) , text = stringResource(
                        R.string.interestingFacts_P4_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfacts5_censorship),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P5_title) , text = stringResource(
                        R.string.interestingFacts_P5_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfacts6),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P6_title) , text = stringResource(
                        R.string.interestingFacts_P6_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfacts7),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P7_title) , text = stringResource(
                        R.string.interestingFacts_P7_body
                    )
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P8_title) , text = stringResource(
                        R.string.interestingFacts_P8_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfacts8_music),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P9_title) , text = stringResource(
                        R.string.interestingFacts_P9_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfacts9_speedrun),
                        contentDescription = null
                    )
                }
                item {
                    ShowParagraph(title = stringResource(R.string.interestingFacts_P10_title) , text = stringResource(
                        R.string.interestingFacts_P10_body
                    )
                    )
                }
                item {
                    Image(
                        modifier = Modifier.size(300.dp, 200.dp),
                        painter = painterResource(
                            id = R.drawable.interestingfacts10_anniversary),
                        contentDescription = null
                    )
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
            Text(text = stringResource(R.string.BackButton_text))
        }
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun InterestingFactsPreview() {
    InterestingFactsScreen(navController = rememberNavController())
}