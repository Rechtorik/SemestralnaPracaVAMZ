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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.R

@Composable
fun MainMenu(
    navController: NavController,
    mmvm: MainMenuViewModel = viewModel()
) {
    val backGround by mmvm.backgroundColor

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(backGround),
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = {
                        mmvm.changeBackgroundColor(Color.Red)
                    }
                ) {
                    Text("MY PLAY")
                }
            }
            item {
                Button(
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { /*TODO*/ }
                ) {
                    Text("INTERESTING FACTS")
                }
            }
            item {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 0.dp) ,
                    onClick = { /*TODO*/ }
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
    MainMenu(mmvm = MainMenuViewModel(), navController = rememberNavController())
}
