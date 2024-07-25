package com.swright.dailynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.swright.dailynewsapp.screens.HomeScreen
import com.swright.dailynewsapp.ui.theme.DailyNewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyNewsAppTheme {
                Surface(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    HomeScreen()
                }
            }
        }
    }
}
