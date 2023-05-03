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
            TextComponent("Android")
        }
    }
}


@Composable
fun TextComponent(value: String) {

    val shadowOffset = Offset(x = 2.0f , y = 4f)

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray)
            .padding(horizontal = 18.dp , vertical = 28.dp)
            ,
        text = stringResource(id = R.string.welcome_message),
        color = Color.Black,
        style = TextStyle(
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(
                color = Color.Green ,
                offset = shadowOffset,
                blurRadius = 2f
            )
        )
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextComponent("Android")
}