package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import tomljanovic.matko.quizatko.R

@Composable
@Preview
@Destination(start = true)
fun SplashScreen(
    navigator: DestinationsNavigator? = null,
) {
    // TODO add scale variable

    LaunchedEffect(key1 = true) {
        // TODO animation
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            ScreenBackground(R.drawable.img_splash)
            // TODO make Column
            Text(text = "Splash screen!")
        }
    }
}

@Composable
fun ScreenBackground(backgroundId: Int) {
    // TODO add background image
}
