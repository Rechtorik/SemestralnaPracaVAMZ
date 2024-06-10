package com.example.semestralnapracadoom.ui.myPlay

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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

@Composable
fun MyPlayNotesScreen(
    navController: NavController ,
    myPlaylViewModel: MyPlaylViewModel,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    val myPlayUiState by myPlaylViewModel.uiState.collectAsState()
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()


    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        ColorBG1, ColorBG2
                    ) ,  // Color(0xFF562d7d) , Color(0xFF000000)
                    center = Offset(1080f , 1920f) , // center of the gradient
                    radius = 1500f + uiState.value // radius of the gradient
                )
            ),
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "All notes" ,
                style = MaterialTheme.typography.titleLarge ,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                color = Color.White,
                modifier = Modifier.padding(30.dp)
            )
            LazyColumn {
                items(myPlayUiState.level.position) { i ->
                    if (myPlaylViewModel.levels[i].note.isNotEmpty()) {
                        var showDialog by remember { mutableStateOf(false) }
                        Button(
                            elevation = ButtonDefaults.buttonElevation(8.dp),
                            onClick = { showDialog = true },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(30.dp , 5.dp)
                        ) {
                            Text(text = myPlaylViewModel.levels[i].name)
                        }
                        if (showDialog) {
                            AlertDialog(
                                onDismissRequest = { showDialog = false },
                                title = { Text(text = myPlaylViewModel.levels[i].name, fontWeight = FontWeight.Bold) },
                                text = { Text(text = myPlaylViewModel.levels[i].note) },
                                confirmButton = {
                                    TextButton(onClick = { showDialog = false }) {
                                        Text(text = "OK")
                                    }
                                }
                            )
                        }
                    }
                }
                item { Spacer(modifier = Modifier.size(120.dp)) }
            }
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp, 30.dp, 30.dp, 80.dp),
        ) {
            Text(text = "Back")
        }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyPlayNotesScreenPreview() {
    MyPlayNotesScreen(
        navController = rememberNavController(),
        myPlaylViewModel = viewModel()
    )
}