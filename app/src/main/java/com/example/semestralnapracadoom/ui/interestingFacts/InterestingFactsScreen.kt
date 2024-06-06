package com.example.semestralnapracadoom.ui.interestingFacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.R
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundViewModel

@Composable
fun InterestingFactsScreen(
    navController: NavController,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
) {
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()
    Box(

    ) {
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
                text = "Interesting Facts",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(20.dp)
            )
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    showParagraph(title = "Pioneer in 3D Graphics:" , text = "Doom is often regarded as one of the first games to feature true 3D graphics. Although the game uses a technique known as \"2.5D\" (first-person perspective with 2D sprites), its speed and fluidity were revolutionary at the time.")
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
                    showParagraph(title = "Multiplayer and Modding:" , text = "Doom was one of the first games to enable players to play together over a network, laying the foundation for modern multiplayer gaming. Additionally, the game supported modding, allowing players to create their own levels and modifications. This led to the emergence of a massive modding community that remains active to this day.")
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
                    showParagraph(title = "Impact on the Gaming Industry" , text = "Doom had a tremendous impact on the gaming industry and helped popularize the FPS (first-person shooter) genre. Its success inspired numerous other games and contributed to the development of modern first-person shooters.")
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
                    showParagraph(title = "Controversy and Censorship" , text = "Doom became a target of controversy due to its violent and satanic themes. The game was banned or censored in some countries. Despite this, it became a cult classic and its popularity remained unaffected.")
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
                    showParagraph(title = "Birth of id Software" , text = "Doom was developed by id Software, founded by John Carmack and John Romero. The game cemented their reputation as pioneers in game development and led to the release of other successful titles like Quake and Wolfenstein 3D.")
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
                    showParagraph(title = "Technical Innovations:" , text = "Doom introduced several technical innovations, such as BSP (Binary Space Partitioning) for efficient level rendering, and advanced lighting and shading techniques for its time.")
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
                    showParagraph(title = "Pop Culture References:" , text = "The game contains numerous references to pop culture, including sci-fi movies and books. Its iconic weapons, enemies, and sound effects have become entrenched in pop culture lexicon.")
                }
                item {
                    showParagraph(title = "Music:" , text = "The game's soundtrack, composed by Robert Prince, was heavily influenced by heavy metal bands like Metallica and Slayer. The music added to the game's atmosphere and is still appreciated by fans today.")
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
                    showParagraph(title = "Speedrunning and Community:" , text = "Doom became one of the first games to support speedrunning – playing the game with the goal of completing it as quickly as possible. The speedrunning community is very active, with regular competitions and events.")
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
                    showParagraph(title = "Anniversaries and Remakes:" , text = "The game has seen several remakes and ports to various platforms. On the occasion of the game's 25th anniversary, special editions and events were held to celebrate its legacy.")
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
                    Spacer(modifier = Modifier.size(30.dp))
                }
            }
        }
        Button(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Menu")
        }
    }
}

@Composable
fun showParagraph(
    title: String,
    text: String
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(0.dp, 20.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            style = typography.titleMedium
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp , 5.dp)
                .background(Color.White.copy(alpha = 0.1f))
            ,
            text = text,
            fontSize = 15.sp,
            style = typography.bodyMedium,
            textAlign = TextAlign.Justify
        )
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun InterestingFactsPreview() {
    InterestingFactsScreen(navController = rememberNavController(), glowingBackgroundViewModel = viewModel())
}