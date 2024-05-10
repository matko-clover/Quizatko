package tomljanovic.matko.quizatko.presentation.quizatko

import android.text.Html
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import timber.log.Timber
import tomljanovic.matko.quizatko.R
import tomljanovic.matko.quizatko.presentation.destinations.EndGameDestination

@Composable
@Destination
@Preview
fun TriviaScreen(
    navigator: DestinationsNavigator? = null,
    viewModel: QuizatkoViewModel = hiltViewModel(),
    maxQuestions: Int = 0,
    playerName: String = ""
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getQuestions(maxQuestions)
    }

    val state = viewModel.state

    val activeQuestion = remember { mutableIntStateOf(0) }

    var clickedButtonIndex by remember { mutableIntStateOf(-1) }

    val playerScore = remember { mutableIntStateOf(0) }

    val isClicked = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ScreenBackground(R.drawable.img_background)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(56.dp)
                    )
                }
            } else {
                if (state.questions.isNotEmpty()) {
                    QuestionToolbar(
                        modifier = Modifier,
                        maxQuestions = maxQuestions,
                        activeQuestion = activeQuestion
                    )

                    Text(
                        text = Html.fromHtml(state.questions[activeQuestion.value].question)
                            .toString(),
                        color = Color.White,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 22.sp
                    )

                    state.questions[activeQuestion.value].answers.forEachIndexed { index, answer ->
                        TriviaButtons(
                            buttonText = Html.fromHtml(answer).toString(),
                            drawableId = null,
                            buttonColor = when {
                                index == clickedButtonIndex && answer == state.questions[activeQuestion.value].correctAnswer -> {
                                    if (!isClicked.value) playerScore.intValue++
                                    isClicked.value = true
                                    Color.Green
                                }

                                index == clickedButtonIndex && answer != state.questions[activeQuestion.value].correctAnswer -> {
                                    isClicked.value = true
                                    Color.Red
                                }

                                else -> Color.White
                            }
                        ) {
                            clickedButtonIndex = index
                        }
                    }

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    val question = activeQuestion.intValue

                    Text(
                        text = if (question == state.questions.size - 1) "Finish" else "Next question",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clickable {
                                if (question == state.questions.size - 1) {
                                    navigator?.navigate(
                                        EndGameDestination(
                                            maxQuestions = maxQuestions,
                                            score = playerScore.value,
                                            playerName = playerName
                                        )
                                    )
                                } else {
                                    activeQuestion.intValue += 1
                                    clickedButtonIndex = -1
                                    isClicked.value = false
                                }
                            }
                    )
                } else {
                    Timber.d("Error: ${state.error}")
                }
            }
        }
    }
}

@Preview
@Composable
fun QuestionToolbar(
    modifier: Modifier = Modifier,
    activeQuestion: MutableState<Int> = mutableIntStateOf(0),
    maxQuestions: Int = 10,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = Color(0xFF232F42)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (activeQuestion.value < maxQuestions) {
                    "Question ${activeQuestion.value + 1} / $maxQuestions"
                } else {
                    "Question ${activeQuestion.value} / $maxQuestions"
                },
                color = Color(0xFFFFCB00),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
