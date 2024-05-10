package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R
import tomljanovic.matko.quizatko.presentation.destinations.LeaderboardScreenDestination
import tomljanovic.matko.quizatko.presentation.destinations.SetUpPlayerDestination

@Composable
@Destination
@Preview
fun StartGameScreen(
    navigator: DestinationsNavigator? = null,
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenBackground(backgroundId = R.drawable.img_background)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TriviaButtons(
                drawableId = R.drawable.img_play,
                buttonText = "Start quiz"
            ) {
                navigator?.navigate(SetUpPlayerDestination)
            }

            TriviaButtons(
                drawableId = R.drawable.img_leaderboard,
                buttonText = "Leaderboard"
            ) {
                navigator?.navigate(LeaderboardScreenDestination)
            }
        }
    }
}

@Composable
@Preview
fun TriviaButtons(
    drawableId: Int? = R.drawable.img_play,
    buttonText: String = "Start quiz",
    enabled: Boolean = true,
    buttonColor: Color = Color(0xFFDFEDF6),
    onClicked: (String) -> Unit = {},
) {
    // TODO make Button
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        onClick = {
            onClicked.invoke(buttonText)
        }
    ) {
        drawableId?.let { painterResource(id = it) }?.let {
            Image(
                painter = it,
                contentDescription = null
            )
        }

        Text(
            text = buttonText,
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 16.dp)
        )
    }
}
