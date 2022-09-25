package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EntireScreen(
                        stringResource(R.string.title1),
                        stringResource(R.string.title2),
                        stringResource(R.string.title3),
                        stringResource(R.string.title4),
                        stringResource(R.string.paragraph1),
                        stringResource(R.string.paragraph2),
                        stringResource(R.string.paragraph3),
                        stringResource(R.string.paragraph4)
                    )
                }
            }
        }
    }
}


@Composable
fun EntireScreen(
    title1 : String,
    title2 : String,
    title3 : String,
    title4 : String,
    para1 : String,
    para2 : String,
    para3 : String,
    para4 : String
    ) {
    Column (Modifier.fillMaxWidth()){
        Row (Modifier.weight(1f)) {
            ComposableCards(
                title =title1,
                paragraph = para1,
                backgroundColor= Color.Green,
                modifier = Modifier.weight(1f)
            )
            ComposableCards(
                title =title2,
                paragraph =para2,
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }

        Row (Modifier.weight(1f)) {
            ComposableCards(
                title =title3,
                paragraph =para3,
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposableCards(
                title =title4,
                paragraph =para4,
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun ComposableCards (title : String, paragraph : String, modifier: Modifier = Modifier, backgroundColor : Color ) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text =paragraph,
                    textAlign = TextAlign.Justify
                )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        EntireScreen(
            stringResource(R.string.title1),
            stringResource(R.string.title2),
            stringResource(R.string.title3),
            stringResource(R.string.title4),
            stringResource(R.string.paragraph1),
            stringResource(R.string.paragraph2),
            stringResource(R.string.paragraph3),
            stringResource(R.string.paragraph4)
        )
    }
}