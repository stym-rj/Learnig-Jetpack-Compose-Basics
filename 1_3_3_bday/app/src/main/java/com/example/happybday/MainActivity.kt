package com.example.happybday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.happybday.ui.theme.HappybdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappybdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // here, we call all the functions which will appear in the android device.
                    BirthdayGreetingWithText(message = "May God Bless You!")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String) {
    Column {
        Text(text = "Greetings $message", fontSize = 30.sp)
        Text(text = "\nSmaller Size", fontSize = 21.sp)
        Text(text = "\ndefault Size")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BirthdayGreetingWithTextPreview() {
//    HappybdayTheme {
//        // here we call all the functions which will appear in compose default preview.
//        BirthdayGreetingWithText(message = "May God Bless You!")
//    }
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HappybdayTheme {
    BirthdayGreetingWithText(message = "hello")
    }
}