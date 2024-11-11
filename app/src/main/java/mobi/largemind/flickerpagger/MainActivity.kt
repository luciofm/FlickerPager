package mobi.largemind.flickerpagger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.MaterialTheme
import mobi.largemind.flickerpagger.ui.theme.FlickerPaggerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                BoxWithConstraints {
                    val items = remember { List(size = 6) { 0 } }
                    val pagerState = rememberPagerState(
                        initialPage = 0,
                        pageCount = { items.size },
                        initialPageOffsetFraction = 0f
                    )

                    val availableWidth = maxWidth
                    val tileWidth = availableWidth.times(.8f)

                    Column(
                        modifier = Modifier.background(Color.White)
                    ) {
                        HorizontalPager(
                            state = pagerState,
                            beyondViewportPageCount = 1,
                            contentPadding = PaddingValues(24.dp),
                            pageSize = PageSize.Fixed(tileWidth),
                            pageSpacing = 24.dp,
                            verticalAlignment = Alignment.CenterVertically,
                        ) { index ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(16f/10f)
                                    .background(Color.Blue),
                                contentAlignment = Alignment.BottomEnd,
                            ) {
                                Button(
                                    onClick = { },
                                    enabled = true,
                                    modifier = Modifier
                                        .padding(vertical = 24.dp, horizontal = 36.dp)
                                ) {
                                    Text(text = "Action $index")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlickerPaggerTheme {
        Greeting("Android")
    }
}