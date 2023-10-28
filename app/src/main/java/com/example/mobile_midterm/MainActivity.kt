package com.example.mobile_midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mobile_midterm.ui.theme.Mobile_MidtermTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile_MidtermTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}


@Composable
fun Content() {
    var red by remember { mutableStateOf(255) }
    var green by remember { mutableStateOf(255) }
    var blue by remember { mutableStateOf(255) }

    val backgroundColor = Color(red, green, blue)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Text("RGB Changer", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Adjust RGB Values to change the background Color", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        SliderComponent(red) { newValue -> red = newValue }
        SliderComponent(green) { newValue -> green = newValue }
        SliderComponent(blue) { newValue -> blue = newValue }
        Spacer(modifier = Modifier.height(16.dp))
        ResetButton {
            red = 255
            green = 255
            blue = 255
        }
    }
}

@Composable
fun SliderComponent(value: Int, onValueChange: (Int) -> Unit) {
    var sliderValue by remember { mutableStateOf(value) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Slider(
            value = value.toFloat(),
            onValueChange = {
                sliderValue = it.toInt()
                onValueChange(sliderValue)
            },
            valueRange = 0f..255f
        )
    }
}

@Composable
fun ResetButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
    ) {
        Text("Reset")
    }
}

@Composable
fun App() {
    MaterialTheme {
        Content()
    }
}