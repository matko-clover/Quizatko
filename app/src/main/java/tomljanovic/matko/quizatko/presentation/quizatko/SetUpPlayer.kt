package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R
import tomljanovic.matko.quizatko.presentation.leaderboard.LeaderboardViewModel

@Composable
@Destination
@Preview
fun SetUpPlayer(
    navigator: DestinationsNavigator? = null,
    viewmodel: LeaderboardViewModel = hiltViewModel()
) {
    // TODO player and number variables

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenBackground(backgroundId = R.drawable.img_background)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Enter your name",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )

            // TODO SetUpEditText

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Select the number of questions",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp, top = 16.dp),
                text = "Max. number of questions is 50",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )

            // TODO SetUpEditText

            Spacer(modifier = Modifier.height(56.dp))

            // TODO Trivia Buttons
        }
    }
}

@Composable
fun SetUpEditText(
    valueState: String = "",
    onValueChange: (String) -> Unit,
    onAction: KeyboardActions = KeyboardActions.Default,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next
) {
    // TODO OutlinedTextField
}
