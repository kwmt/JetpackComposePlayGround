package net.kwmt27.jetpackcomposeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import net.kwmt27.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlayGroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

private val BlackScrim = Color(0f, 0f, 0f, 0.2f)
private val BlackScrimmed: (Color) -> Color = { background ->
    // これは、色を別の色の上に重ねることができ、その結果の色を返します。
    // https://android-review.googlesource.com/c/platform/frameworks/support/+/1182625
    BlackScrim.compositeOver(background)
}

@Composable
fun Greeting(name: String) {
    Column() {
        Text(text = "Hello $name!", color = Color.Blue)
        Text(text = "Hello $name!", color = BlackScrimmed(Color.Blue))
        Text(text = "Hello $name!", color = Color.Red)
        Text(text = "Hello $name!", color = BlackScrimmed(Color.Red))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposePlayGroundTheme {
        Greeting("Android")
    }
}