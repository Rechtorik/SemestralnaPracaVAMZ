package com.example.semestralnapracadoom.ui.quiz

import android.content.res.Configuration
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
fun QuizScreen(
    navController: NavController
) {
    val config = LocalConfiguration.current
    val mode = remember { mutableStateOf(config.orientation) }
    if (mode.value == Configuration.ORIENTATION_PORTRAIT) {
        QuizScreenPortrait(navController = navController)
    } else {
        QuizScreenLandscape(navController = navController)
    }
}


@Composable
fun QuizScreenPortrait(
    navController: NavController ,
    viewModel: QuizViewModel = viewModel() ,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    val quizUiState by viewModel.uiState.collectAsState()
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()

    Box (
        modifier = Modifier
        .background(
            brush = Brush.radialGradient(
                colors = listOf(ColorBG1, ColorBG2) ,
                center = Offset(1080f , 1920f) , // center of the gradient
                radius = 1500f + uiState.value // radius of the gradient
            )),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.size(50 .dp))
            ShowQuestion(viewModel = viewModel , quizUiState = quizUiState)
            if (quizUiState.isGameOver) {
                FinalScoreDialog(
                    navController = navController ,
                    viewModel = viewModel ,
                    quizUiState = quizUiState
                )
            }
        }
        Column (
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.quiz_title) ,
                style = typography.titleLarge ,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                color = Color.White,
                modifier = Modifier.padding(30.dp),
                textAlign = TextAlign.Center
            )
            Text(
                color = Color.White,
                textAlign = TextAlign.Center,
                text = "Score: ${quizUiState.score} \nQuestion ${quizUiState.numberOfQuestions}/10" ,
                style = typography.titleLarge ,
                fontWeight = FontWeight.Light,
                fontSize = 30.sp,
                modifier = Modifier.background(Color.White.copy(alpha = 0.3f))
            )
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(80.dp),
            onClick = { navController.popBackStack()
            }
        ) {
            Text(text = stringResource(id = R.string.BackButton_text))
        }
    }
}



@Composable
fun QuizScreenLandscape(
    navController: NavController ,
    viewModel: QuizViewModel = viewModel() ,
    glowingBackgroundViewModel: GlowingBackgroundViewModel = viewModel()
) {
    // BackGround Color Theme
    var ColorBG1 = Color.Red
    var ColorBG2 = Color.Blue
    if (isSystemInDarkTheme()) {
        ColorBG1 = Color(0xFF562d7d)
        ColorBG2 = Color(0xFF000000)
    }
    val quizUiState by viewModel.uiState.collectAsState()
    val uiState by glowingBackgroundViewModel.uiState.collectAsState()

    Box (
        modifier = Modifier
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(ColorBG1, ColorBG2) ,
                    center = Offset(1920f , 1080f) , // center of the gradient
                    radius = 1500f + uiState.value // radius of the gradient
                )),
        contentAlignment = Alignment.Center
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp , 0.dp)
        ) {
            Column (
                modifier = Modifier
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.quiz_title) ,
                    style = typography.titleLarge ,
                    fontWeight = FontWeight.Bold,
                    fontSize = 60.sp,
                    color = Color.White,
                    modifier = Modifier.padding(30.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    text = "Score: ${quizUiState.score} \nQuestion ${quizUiState.numberOfQuestions}/10" ,
                    style = typography.titleLarge ,
                    fontWeight = FontWeight.Light,
                    fontSize = 30.sp,
                    modifier = Modifier.background(Color.White.copy(alpha = 0.3f))
                )
                Button(
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .padding(30.dp),
                    onClick = { navController.popBackStack() }
                ) {
                    Text(text = stringResource(id = R.string.BackButton_text))
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally ,
                verticalArrangement = Arrangement.Center ,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ShowQuestion(viewModel = viewModel , quizUiState = quizUiState)
                if (quizUiState.isGameOver) {
                    FinalScoreDialog(
                        navController = navController ,
                        viewModel = viewModel ,
                        quizUiState = quizUiState
                    )
                }
            }
        }
    }
}


@Composable
fun ShowQuestion(
    viewModel: QuizViewModel,
    quizUiState: QuizUiState
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(0.dp, 20.dp)
    ) {
        Text(
            color = Color.White,
            text = quizUiState.curQuestion.question,
            style = typography.displaySmall,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(40.dp , 20.dp , 40.dp , 40.dp)
                .background(Color.White.copy(alpha = 0.2f)),
            textAlign = TextAlign.Justify
        )
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = {
                if (quizUiState.curQuestion.rightPosition == 0) {
                    viewModel.RightAnswer()
                } else {
                    viewModel.ButtonClicked()
                } },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = quizUiState.curQuestion.firstOption,
                style = typography.bodyLarge
            )
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = {
                if (quizUiState.curQuestion.rightPosition == 1) {
                    viewModel.RightAnswer()
                } else {
                    viewModel.ButtonClicked()
                } },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = quizUiState.curQuestion.secondOption,
                style = typography.bodyLarge
            )
        }
        Button(
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = {
                if (quizUiState.curQuestion.rightPosition == 2) {
                    viewModel.RightAnswer()
                } else {
                    viewModel.ButtonClicked()
                } },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = quizUiState.curQuestion.rightOption,
                style = typography.bodyLarge
            )
        }
    }
}


@Composable
private fun FinalScoreDialog(
    navController: NavController,
    viewModel: QuizViewModel,
    quizUiState: QuizUiState
    ) {
    AlertDialog(
        onDismissRequest = {
            navController.popBackStack()
        },
        title = { Text(text = stringResource(R.string.quiz_endOfQuiz)) },
        text = { Text(text = "Your score: ${quizUiState.score}/10") },
        dismissButton = {
            TextButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = stringResource(id = R.string.BackButton_text))
            }
        },
        confirmButton = {
            TextButton(onClick = {
                viewModel.Reset()
            }) {
                Text(text = stringResource(R.string.quiz_playAgain))
            }
        }
    )
}







@Preview (
    showSystemUi = true,
    showBackground = true
)
@Composable
fun QuizScreenPreview() {
    QuizScreenPortrait(
        navController = rememberNavController()
    )
}