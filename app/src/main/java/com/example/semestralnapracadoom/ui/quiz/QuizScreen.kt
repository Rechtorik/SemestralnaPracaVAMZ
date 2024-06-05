package com.example.semestralnapracadoom.ui.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizScreen(
    navController: NavController,
    viewModel: QuizViewModel = viewModel()
) {
    val quizUiState by viewModel.uiState.collectAsState()

    Box (
        contentAlignment = Alignment.Center
    ) {
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
        Column (
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(30.dp),
                textAlign = TextAlign.Center,
                text = "Quiz" ,
                style = typography.titleLarge ,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Score: ${quizUiState.score} \nQuestion ${quizUiState.numberOfQuestions}/10" ,
                style = typography.titleLarge ,
                fontWeight = FontWeight.Light
            )
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp),
            onClick = { navController.navigate("main_menu") }
        ) {
            Text(text = "Back")
        }
    }
}


@Composable
fun ShowQuestion(
    viewModel: QuizViewModel,
    quizUiState: QuizUiState
) {
    Text(
        text = quizUiState.curQuestion.question,
        style = typography.bodyLarge,
        fontSize = 20.sp,
        modifier = Modifier.padding(40.dp),
        textAlign = TextAlign.Justify
    )
    Button(
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


@Composable
private fun FinalScoreDialog(
    navController: NavController,
    viewModel: QuizViewModel,
    quizUiState: QuizUiState
    ) {
    AlertDialog(
        onDismissRequest = {
            navController.navigate("main_menu")
        },
        title = { Text(text = "End of Quiz") },
        text = { Text(text = "Your score: ${quizUiState.score}/10") },
        dismissButton = {
            TextButton(
                onClick = {
                    navController.navigate("main_menu")
                }
            ) {
                Text(text = "Main Menu")
            }
        },
        confirmButton = {
            TextButton(onClick = {
                viewModel.Reset()
            }) {
                Text(text = "Play Again")
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
    QuizScreen(
        navController = rememberNavController(),
        viewModel = viewModel()
    )
}