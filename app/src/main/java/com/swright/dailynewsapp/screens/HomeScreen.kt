package com.swright.dailynewsapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

    println(newsViewModel.gwtWeatherVM())
    println(state.weatherText)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(

            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text(
                    text = "Today's date is:",
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(start = 8.dp)
                )
                val currentDate = SimpleDateFormat("EEEE, MMM d", Locale.ROOT).format(Date())
                Text(
                    text = currentDate + "th",
                    fontSize = 36.sp,
                    modifier = Modifier.fillMaxWidth().padding(start = 24.dp)
                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(

            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text(
                    text = "Today's weather:",
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = state.weatherTempDegrees + "°C",
                    fontSize = 36.sp,
                    modifier = Modifier.padding(start = 24.dp)
                )
                Text(
                    text = state.weatherText,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(start = 24.dp)
                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(

            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { newsViewModel.getUkNewsListVM() }) {
                    Text(
                        text = "UK News",
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(onClick = { newsViewModel.getWorldNewsListVM() }) {
                    Text(
                        text = "World News",
                        fontSize = 20.sp
                    )
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
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}