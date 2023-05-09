package com.nativemobilebits.learnjetpackcompose

import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nativemobilebits.learnjetpackcompose.networking.NetworkChecker
import com.nativemobilebits.learnjetpackcompose.networking.RemoteApi
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private val networkChecker by lazy {
        NetworkChecker(getSystemService(ConnectivityManager::class.java))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(networkChecker)
        }
    }
}

@Composable
fun MainScreen(networkChecker: NetworkChecker) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {

        RemoteApi().getFact()
    }
}


@Composable
fun TextComponent(value: String, shadowColor: Color) {

    val shadowOffset = Offset(x = 4f, y = 6f)

    Text(
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .padding(18.dp),
        text = value,
        color = Color.Black,
        style = TextStyle(
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(shadowColor, shadowOffset, 2f)
        )
    )
}

@Composable
fun EvenNumbers() {

    for (number in 2..10) {
        if (number % 2 == 0) {

            val color = Color(
                red = Random.nextInt(256),
                green = Random.nextInt(256),
                blue = Random.nextInt(256)
            )
            TextComponent(number.toString(), color)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    MainScreen(networkChecker, remoteApi)
}