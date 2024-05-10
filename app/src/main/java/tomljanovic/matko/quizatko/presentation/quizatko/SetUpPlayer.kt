package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R
import tomljanovic.matko.quizatko.presentation.leaderboard.LeaderboardViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Destination
fun SetUpPlayer(
    navigator: DestinationsNavigator? = null,
    viewmodel: LeaderboardViewModel = hiltViewModel()
) {
    // TODO player and number variables
    val playerName = remember {
        mutableStateOf("")
    }

    val isPlayerNameValid = remember(playerName) {
        playerName.value.trim().isNotEmpty()
    }

    val questionNumber = remember {
        mutableStateOf("")
    }

    val isQuestionNumberValid = remember(questionNumber) {
        questionNumber.value.toIntOrNull() in 1..50
    }

    val keyBoardController = LocalSoftwareKeyboardController.current

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
            SetUpEditText {

            }

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
            SetUpEditText {

            }

            Spacer(modifier = Modifier.height(56.dp))

            // TODO Trivia Buttons
            TriviaButtons(
                drawableId = R.drawable.img_play,
                buttonText = "Start quiz"
            ) {

            }
        }
    }
}

@Composable
fun SetUpEditText(
    valueState: String = "",
    onAction: KeyboardActions = KeyboardActions.Default,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = valueState,
        onValueChange = onValueChange,
        maxLines = 1,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            focusedBorderColor = Color.White,
            unfocusedTextColor = Color.White
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 18.sp
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}
