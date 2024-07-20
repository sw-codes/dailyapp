package com.swright.dailynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swright.dailynewsapp.screens.HomeScreen
import com.swright.dailynewsapp.ui.theme.DailyNewsAppTheme
import com.swright.dailynewsapp.viewmodels.NewsViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            DailyNewsAppTheme {
//                val currentDate = SimpleDateFormat("yyyy-M-dd", Locale.ROOT).format(Date())
//                println(currentDate)
                HomeScreen()
            }
        }
    }
}
