package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R

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
            // TODO add TriviaButtons
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
}
