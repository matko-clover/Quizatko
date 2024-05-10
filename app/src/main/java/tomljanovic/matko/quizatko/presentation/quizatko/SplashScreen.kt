package tomljanovic.matko.quizatko.presentation.quizatko

import android.view.animation.OvershootInterpolator
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import tomljanovic.matko.quizatko.R
import tomljanovic.matko.quizatko.presentation.destinations.StartGameScreenDestination

@Composable
@Preview
@Destination(start = true)
fun SplashScreen(
    navigator: DestinationsNavigator? = null,
) {
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = androidx.compose.animation.core.tween(
                durationMillis = 800,
                easing = {
                         OvershootInterpolator(8f).getInterpolation(it)
                },
            )
        )
        delay(2000L)
        navigator?.navigate(StartGameScreenDestination)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            ScreenBackground(R.drawable.img_splash)
            Column (
                horizontalAlignment =  Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.scale(scale.value)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Quitzatko",
                    color = Color.White,
                    style = MaterialTheme.typography.displayLarge
                )
            }
            Column (
                horizontalAlignment =  Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ){
                Text(
                    text = "Powered by",
                    color = Color.White
                )
                Image(
                    modifier = Modifier.padding(bottom = 16.dp),
                    painter = painterResource(id = R.drawable.img_clover),
                    contentDescription = null)
            }
        }
    }
}

@Composable
fun ScreenBackground(backgroundId: Int = R.drawable.img_splash) {
    Image(
        painter = painterResource(id = backgroundId),
        contentDescription = "Background image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.None
    )
}
