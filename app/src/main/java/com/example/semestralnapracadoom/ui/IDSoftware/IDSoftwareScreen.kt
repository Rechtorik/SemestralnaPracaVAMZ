package com.example.semestralnapracadoom.ui.IDSoftware

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
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
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()
    Box {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "ID Software",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(15.dp),
                color = Color.White,
                fontSize = 30.sp
            )
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ShowParagraph(title = "The Beginnings of id Software" , text = "id Software was founded in February 1991 by four key individuals: John Carmack, John Romero, Tom Hall, and Adrian Carmack. The team initially worked at a company called Softdisk, where they created games for the PC and Apple II platforms. However, they had bigger ambitions and wanted to develop their own games independently.")
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
                    ShowParagraph(title = "" , text = "The breakthrough came when John Carmack developed a revolutionary technique for smooth-scrolling graphics on the PC. This technique was showcased in their first game, Commander Keen, which they developed in their spare time while still employed at Softdisk. The game was a huge success, proving that the team had the talent and vision to make it on their own.")
                }
                item { 
                    ShowParagraph(title = "" , text = "Encouraged by the success of Commander Keen, the team left Softdisk and officially founded id Software. They quickly established themselves as pioneers in the gaming industry, creating groundbreaking titles such as Wolfenstein 3D, Doom, and Quake. These games not only set new standards for graphics and gameplay but also laid the foundation for the first-person shooter genre.")
                }
                item {
                    Row(
                        modifier = Modifier
                            .padding(25.dp)
                            .size(250.dp, 150.dp),
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
                    Spacer(modifier = Modifier.size(80.dp))
                }
            }
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp),
            onClick = { navController.navigate(NavRoute.MAIN_MENU.route) }
        ) {
            Text(text = "Back")
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