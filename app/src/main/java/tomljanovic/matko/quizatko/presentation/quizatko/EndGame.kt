package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R
import tomljanovic.matko.quizatko.presentation.leaderboard.LeaderboardViewModel

@Composable
@Destination
@Preview
fun EndGame(
    navigator: DestinationsNavigator? = null,
    leaderboardViewModel: LeaderboardViewModel = hiltViewModel(),
    maxQuestions: Int = 0,
    score: Int = 0,
    playerName: String = ""
) {
    LaunchedEffect(key1 = Unit) {
        // TODO add player
    }

    ScreenBackground(backgroundId = R.drawable.img_background)

    val doneQuestion = remember {
        mutableIntStateOf(maxQuestions)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // TODO add toolbar

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // TODO "Your score" text

            // TODO result

        }

        // TODO add trivia button

        // TODO add menu
    }
}