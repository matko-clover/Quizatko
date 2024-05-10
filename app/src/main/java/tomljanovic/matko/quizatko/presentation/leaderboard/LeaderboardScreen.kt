package tomljanovic.matko.quizatko.presentation.leaderboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(56.dp)
                )
            }
        } else {
            if (state.items.isNotEmpty()) {
                LeaderboardTitle()

                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    itemsIndexed(
                        items = state.items.sortedByDescending { it.score }
                    ) { index, item ->
                        if (index < 3) {
                            TopPlayers(
                                leaderBoardPlayer = item,
                                place = index + 1
                            )
                        } else {
                            OtherPlayers(
                                leaderBoardPlayer = item,
                                place = index + 1
                            )
                        }
                    }
                }

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
        Image(
            painter = painterResource(id = R.drawable.img_medal),
            contentDescription = null,
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = "Leaderboard",
            modifier = Modifier.padding(bottom = 32.dp),
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFFFFCB00),
            fontWeight = FontWeight.W500
        )
    }
}

@Composable
@Preview
fun TopPlayers(
    leaderBoardPlayer: LeaderboardItem = LeaderboardItem(score = 0, name = "Test"),
    place: Int = 1
) {
    val surfaceSize = when (place) {
        1 -> 56.dp
        2 -> 48.dp
        3 -> 40.dp
        else -> 40.dp
    }

    val color = when (place) {
        1 -> Color(0xFFFFCB00)
        2 -> Color(0xFFD4D4D4)
        3 -> Color(0xFFE18A3A)
        else -> Color(0xFFE18A3A)
    }

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
            Surface(
                modifier = Modifier.size(surfaceSize),
                shape = CircleShape,
                color = color
            ) {
                Text(
                    text = place.toString(),
                    modifier = Modifier.wrapContentSize(),
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        Text(
            text = leaderBoardPlayer.name,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = leaderBoardPlayer.score.toString(),
            color = Color(0xFFFFCB00),
            modifier = Modifier.padding(end = 16.dp),
            style = MaterialTheme.typography.titleLarge

        )
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
    Text(
        modifier = modifier,
        text = text,
        color = Color.Black,
        fontSize = 17.sp,
        fontWeight = if (isBolded) FontWeight.Bold else FontWeight.Normal
    )
}