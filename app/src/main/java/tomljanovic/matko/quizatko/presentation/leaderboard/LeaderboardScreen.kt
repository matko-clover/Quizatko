package tomljanovic.matko.quizatko.presentation.leaderboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R
import tomljanovic.matko.quizatko.domain.model.LeaderboardItem
import tomljanovic.matko.quizatko.presentation.destinations.StartGameScreenDestination
import tomljanovic.matko.quizatko.presentation.quizatko.ScreenBackground

@Composable
@Preview
@Destination
fun LeaderboardScreen(
    navigator: DestinationsNavigator? = null,
    viewModel: LeaderboardViewModel = hiltViewModel()
) {
    val state = viewModel.state

    ScreenBackground(backgroundId = R.drawable.img_background)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        if (state.isLoading) {
            // TODO add loading Box

        } else {
            LeaderboardTitle()

            // TODO make LazyColumn

            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .clickable {
                        navigator?.navigate(StartGameScreenDestination)
                    },
                text = "Back",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
@Preview
fun LeaderboardTitle() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO
    }
}

@Composable
@Preview
fun TopPlayers(
    leaderBoardPlayer: LeaderboardItem = LeaderboardItem(score = 0, name = "Test"),
    place: Int = 1
) {
    // TODO surfaceSize
    val surfaceSize = 40.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.size(56.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // TODO - Surface with Text
        }

        // TODO texts
    }
}

@Composable
@Preview
fun OtherPlayers(
    leaderBoardPlayer: LeaderboardItem = LeaderboardItem(score = 0, name = "Test"),
    place: Int = 0
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFD4D4D4)
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OtherPlayersText(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                text = place.toString(),
                isBolded = true
            )

            OtherPlayersText(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                text = leaderBoardPlayer.name,
            )

            OtherPlayersText(
                modifier = Modifier.padding(16.dp),
                text = leaderBoardPlayer.score.toString(),
                isBolded = true
            )
        }
    }
}

@Composable
fun OtherPlayersText(
    modifier: Modifier = Modifier,
    text: String = "",
    isBolded: Boolean = false
) {
    // TODO make Text
}