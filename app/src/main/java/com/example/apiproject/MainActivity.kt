package com.example.apiproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.apiproject.screens.RecipeScreen
import com.example.apiproject.ui.theme.ApiProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            ApiProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RecipeScreen()
                }
            }
        }
    }
}