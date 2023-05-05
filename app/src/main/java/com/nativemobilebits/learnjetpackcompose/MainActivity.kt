package com.nativemobilebits.learnjetpackcompose

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
    ) {
        TextComponent("Android", shadowColor = Color.Yellow)
        TextComponent("Kotlin", shadowColor =  Color.Green)
    }
}


@Composable
fun TextComponent(value: String, shadowColor: Color) {

    val shadowOffset = Offset(x= 4f, y=6f)

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.LightGray)
            .padding(18.dp),
        text = "${stringResource(id = R.string.welcome_message)} $value",
        color = Color.Black,
        style = TextStyle(
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(shadowColor ,shadowOffset ,2f )
        )
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}