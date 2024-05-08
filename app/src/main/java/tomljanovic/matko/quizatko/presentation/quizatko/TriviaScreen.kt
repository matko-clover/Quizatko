package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R

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

    val activeQuestion = remember {
        mutableIntStateOf(0)
    }

    // TODO add other variables

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
                // TODO add loading Box
            } else {
                QuestionToolbar(
                    modifier = Modifier,
                    maxQuestions = maxQuestions,
                    activeQuestion = activeQuestion
                )

                if (state.questions.isNotEmpty()) {
                    // TODO add TriviaButtons with possible answers
                }
            }
        }
    }
}

@Composable
fun QuestionToolbar(
    modifier: Modifier = Modifier,
    activeQuestion: MutableState<Int> = mutableIntStateOf(0),
    maxQuestions: Int,
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
            // TODO add Text
        }
    }
}
