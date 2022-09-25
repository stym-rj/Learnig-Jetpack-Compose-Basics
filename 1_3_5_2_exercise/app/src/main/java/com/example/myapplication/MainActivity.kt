package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Paragraph
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
                    CoverImage(
                        title = stringResource(R.string.title_jetpack_compose),
                        para1Text = stringResource(R.string.paragraph1_text),
                        para2Text = stringResource(R.string.paragraph2_text)
                    )

                }
            }
        }
    }
}

@Composable
fun CoverImage(title : String, para1Text: String, para2Text : String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        TitleText(title)
        Paragraph1(messages = para1Text)
        Paragraph2(messages = para2Text)
    }
}

@Composable
fun TitleText(title : String ) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp, 
                top = 16.dp, 
                bottom = 16.dp
            )
    )
}

@Composable
fun Paragraph1(messages : String ) {
    Text(
        text = messages,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
            )
    )
}

@Composable
fun Paragraph2(messages : String ) {
    Text(
        text = messages,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 16.dp
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CoverImage(
            title = stringResource(R.string.title_jetpack_compose),
            para1Text = stringResource(R.string.paragraph1_text),
            para2Text = stringResource(R.string.paragraph2_text)
        )
    }
}