package com.example.semestralnapracadoom.ui.lore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.R

@Composable
fun LoreScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
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
                        modifier = Modifier
                            .padding(40.dp, 20.dp)
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
                        text = stringResource(R.string.lore_1) ,
                        style = typography.bodyLarge,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(40.dp, 20.dp)
                    )
                }
            }
        }
        Button(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Back!")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun LoreScreenPreview() {
    LoreScreen(navController = rememberNavController())
}