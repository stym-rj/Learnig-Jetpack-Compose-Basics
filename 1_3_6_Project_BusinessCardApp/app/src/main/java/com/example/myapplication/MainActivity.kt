package com.example.myapplication

import android.graphics.Paint.Align
import android.media.Image
import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorInt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
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
                    BusinessCard(fullName = "Satyam Raj")
                }
            }
        }
    }
}

@Composable
fun BusinessCard( fullName: String) {
    val bg1color = R.color.android_background
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFF003A4A)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Logo()
        Title(fullName)
        Details()
    }
}

@Composable
fun DetailsRow (image : Painter, imgValue : String) {
    Row (
        modifier = Modifier
            .padding(top = 10.dp, start = 40.dp, bottom = 10.dp)
            ) {
        Image(painter = image, contentDescription = null)
        Text(
            text = imgValue,
            color= Color.White,
            modifier = Modifier
                .padding(start = 20.dp)
        )
    }
}

@Composable
fun Details() {
    Column(
        modifier = Modifier
            .padding(top = 100.dp)
    ) {
        Divider(color = Color.LightGray, thickness = 1.dp)
        val img1 = painterResource(id = R.drawable.ic_baseline_phone_24)
        val imgValue1 = "+91 7982 295352"
        DetailsRow(image = img1, imgValue = imgValue1)


        Divider(color = Color.LightGray, thickness = 1.dp)
        val img2 = painterResource(id = R.drawable.ic_baseline_share_24)
        val imgValue2 = "Share on GitHub"
        DetailsRow(image = img2, imgValue = imgValue2)


        Divider(color = Color.LightGray, thickness = 1.dp)
        val img3 = painterResource(id = R.drawable.ic_baseline_mail_24)
        val imgValue3 = "mytempemail@gmail.com"
        DetailsRow(image = img3, imgValue = imgValue3)
    }

}

@Composable
fun Title ( fullName : String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 5.dp)
            ) {
        Text(
            text = fullName,
            fontSize = 50.sp,
            fontWeight = FontWeight.Thin,
            color = Color(0xFFFFFFFF)
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84),
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

@Composable
fun Logo () {
    val image = painterResource(id = R.drawable.android_logo_2019)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 180.dp, start = 150.dp, end = 150.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        BusinessCard(fullName = "Satyam Raj")
    }
}