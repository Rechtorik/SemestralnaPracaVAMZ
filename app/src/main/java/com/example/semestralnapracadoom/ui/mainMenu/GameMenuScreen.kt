package com.example.semestralnapracadoom.ui.mainMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.R
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundViewModel

@Composable
fun MainMenu(
    navController: NavController,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
    ) {
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Red , Color.Blue) ,
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
        LazyColumn (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { /*TODO*/ }
                ) {
                    Text("MY PLAY")
                }
            }
            item {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate("lore") }
                ) {
                    Text("LORE")
                }
            }
            item {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate("monsters") }
                ) {
                    Text("MONSTERS")
                }
            }
            item {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { /*TODO*/ }
                ) {
                    Text("DEVELOPMENT")
                }
            }
            item {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { /*TODO*/ }
                ) {
                    Text("ID SOFTWARE")
                }
            }
            item {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate("interesting_facts") }
                ) {
                    Text("INTERESTING FACTS")
                }
            }
            item {
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { navController.navigate("quiz") }
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
    MainMenu(navController = rememberNavController())
}
