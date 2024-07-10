//package com.example.flightscry
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.flightscry.ui.theme.FlightscryTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            FlightscryTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FlightscryTheme {
//        Greeting("Android")
//    }
//}

package com.example.flightscry

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.flightscry.ui.theme.FlightscryTheme
import net.skyscanner.backpack.card.BpkCardView
import net.skyscanner.backpack.text.BpkText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlightscryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FlightInfoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FlightInfoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        FlightInfoCard(
            title = "Flight Number",
            content = "SK123"
        )
        FlightInfoCard(
            title = "Departure",
            content = "JFK - 08:00 AM"
        )
        FlightInfoCard(
            title = "Arrival",
            content = "LAX - 11:00 AM"
        )
    }
}

@Composable
fun FlightInfoCard(title: String, content: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    AndroidView(
        factory = { context ->
            BpkCardView(context).apply {
                padded = true
                elevationLevel = BpkCardView.ElevationLevel.FOCUSED
                cornerStyle = BpkCardView.CornerStyle.LARGE
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                val titleText = BpkText(context).apply {
                    text = title
                    textStyle = BpkText.TextStyle.Heading5
                }

                val contentText = BpkText(context).apply {
                    text = content
                    textStyle = BpkText.TextStyle.BodyDefault
                }

                val linearLayout = LinearLayout(context).apply {
                    orientation = LinearLayout.VERTICAL
                    setPadding(16, 16, 16, 16)  // Adding padding around the content
                }

                linearLayout.addView(titleText)
                linearLayout.addView(contentText)

                addView(linearLayout)
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun FlightInfoScreenPreview() {
    FlightscryTheme {
        FlightInfoScreen()
    }
}

