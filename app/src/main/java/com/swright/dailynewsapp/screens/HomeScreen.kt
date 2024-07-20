package com.swright.dailynewsapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swright.dailynewsapp.viewmodels.NewsViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen() {
    val newsViewModel = viewModel<NewsViewModel>()
    val state = newsViewModel.state

    Column(modifier = Modifier.fillMaxSize().padding(top = 12.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Today's date is:",
                fontSize = 20.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(start = 8.dp)
            )
            val currentDate = SimpleDateFormat("dd/M/yyyy", Locale.ROOT).format(Date())
            Text(
                text = currentDate,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column {
            Text(text = "Weather:", fontSize = 24.sp)
            Text(text = "Degrees C", fontSize = 24.sp)
            Text(text = "Weather type", fontSize = 24.sp)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { newsViewModel.getUkNewsListVM() }) {
                Text(text = "UK News",
                    fontSize = 20.sp)
            }
            Button(onClick = { newsViewModel.getWorldNewsListVM() }) {
                Text(text = "World News",
                    fontSize = 20.sp)
            }
        }
        LazyColumn(modifier = Modifier.padding(top = 8.dp, start = 12.dp, end = 12.dp)) {
            items(state.newsItems.size) {
                Text(
                    text = state.newsItems[it].webTitle,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}