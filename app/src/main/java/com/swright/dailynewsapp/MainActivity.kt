package com.swright.dailynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.swright.dailynewsapp.screens.HomeScreen
import com.swright.dailynewsapp.theme.DailyNewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyNewsAppTheme {
                HomeScreen()
            }
        }
    }
}
