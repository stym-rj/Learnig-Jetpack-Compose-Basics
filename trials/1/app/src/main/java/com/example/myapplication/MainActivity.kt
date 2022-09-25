package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    // here, we call all the functions which will appear in the android device.
                    name("Satyam Raj")
                    thisWontAppearInView()
//                    thisWillAppearInView()
                }
            }
        }
    }
}



@Composable
fun name(name: String ) {
    Text(text = "Happy Birthday $name")
    Text(text= "hello")
}

@Composable
fun thisWontAppearInView() {
    Text(text = "this wont appear since we haven't defined this funciton in the DefaultPreview() function.")
}

@Composable
fun thisWillAppearInView(){
    Column {
        Text(text = "\nLook, this will appear as this function is inside DefaultPreview() function.")
        Text(text = "\n\nLarger font", fontSize = 40.sp)
        Text(text = "Smaller font", fontSize = 20.sp)
        Row {
            Text(text = "One\t")
            Text(text = "Two\t")
            Text(text = "Three\t")
        }
    }
}

@Composable
fun ForDifferentScreen() {
    Row {
        Column {
            Text(text= "One        ")
            Text(text= "One        ")
            Text(text= "One        ")
        }
        Column {
            Text(text= "One        ")
            Text(text= "One        ")
            Text(text= "One        ")
        }
        Column {
            Text(text= "One        ")
            Text(text= "One        ")
            Text(text= "One        ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForDifferentScreenPreview() {
    MyApplicationTheme {
        ForDifferentScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        // here we call all the functions which will appear in compose default preview.
//        name("Satyam Raj")
        thisWillAppearInView()
    }
}


// through this way, we can have different views of each functions.
@Preview(showBackground = true)
@Composable
fun namePreview() {
    MyApplicationTheme {
        name("hello world!")
    }
}