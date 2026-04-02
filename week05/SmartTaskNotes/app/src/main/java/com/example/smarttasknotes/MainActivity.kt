package com.example.smarttasknotes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smarttasknotes.ui.screens.Week05HomeScreenB
import com.example.smarttasknotes.ui.screens.Week05HomeScreenC
import com.example.smarttasknotes.ui.theme.SmartTaskNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("greenzoa","onCreate")
//        enableEdgeToEdge()
        setContent {
            SmartTaskNotesTheme {
                Week05HomeScreenC()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("greenzoa","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("greenzoa","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("greenzoa","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("greenzoa","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("greenzoa","onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartTaskNotesTheme {
        Greeting("Android")
    }
}