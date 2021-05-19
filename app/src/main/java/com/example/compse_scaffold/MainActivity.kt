package com.example.compse_scaffold

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compse_scaffold.ui.theme.CompseScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        Scaffold(topBar = { topBar() }, bottomBar = {ButtomBar()}) {
            LazyColumn {
                items((1..20).toList()){
                    Text("Some Item", modifier = Modifier.padding(4.dp).align(Alignment.CenterHorizontally))
                    Divider(color = Color(0xFF606565), thickness = 1.dp)
                }
            }
        }
    }
}

@Composable
fun Drawer() {
    Column(modifier = Modifier.padding(10.dp).fillMaxWidth().fillMaxHeight().background(Color(0xFFB3E0E1))){

    }
}

@Composable
fun ButtomBar() {

    Row(modifier = Modifier.background(Color(0xFFadd8e6)).fillMaxWidth().height(60.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp)) {
            Icon(
                Icons.Filled.Home,
                "Home Button",
                tint = Color(0xFFd3d3d3),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp)) {
            Icon(
                Icons.Filled.AccountCircle,
                "Home Button",
                tint = Color(0xFFd3d3d3),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp)) {
            Icon(
                Icons.Filled.Settings,
                "Home Button",
                tint = Color(0xFFd3d3d3),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun topBar() {
    Surface(modifier = Modifier.fillMaxWidth(), elevation = 8.dp, color = MaterialTheme.colors.onError) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {

            var inputvalue = remember { mutableStateOf("Text") }

            TextField(
                modifier = Modifier.width(300.dp),
                value = inputvalue.value,
                textStyle = TextStyle(color = Color(0xFF000000)),
                onValueChange = {
                     inputvalue.value = it
                },
                label = { Text("Search")
                }
            )

            Button(onClick = {

            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.width(60.dp).height(55.dp)){
                Icon(
                    Icons.Filled.Search,
                    "contentDescription",
                    tint = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompseScaffoldTheme {
        Greeting()
    }
}