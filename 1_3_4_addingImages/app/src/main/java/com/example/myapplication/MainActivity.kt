package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
                    BirthdayImages(
                        stringResource(R.string.greetings_text),
                        stringResource(R.string.greeters_name)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreets( message : String, from : String ) {
    Column {
        Text(text = message,
            fontSize = 30.sp,
            color= Color.Magenta,
            fontWeight = FontWeight(1000),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    start = 20.dp,
                    end = 10.dp,
                    top = 50.dp
                )
        )
        Text(
            text = "- " +
                    from,
            fontSize = 20.sp,
            color= Color.Green,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(end = 20.dp, start = 10.dp, top = 10.dp)
        )
    }
}

@Composable
fun BirthdayImages(message : String, from : String) {
    val image = painterResource(id = R.drawable.celebration)

    Box {
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreets(
            message = message,
            from = from
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        BirthdayImages( stringResource(R.string.greetings_text), 
            stringResource(R.string.greeters_name)
        )
    }
}