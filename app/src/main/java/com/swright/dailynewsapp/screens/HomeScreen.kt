package com.swright.dailynewsapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swright.dailynewsapp.R
import com.swright.dailynewsapp.ui.theme.DailyNewsAppTheme
import com.swright.dailynewsapp.viewmodels.MyViewModel
import com.swright.dailynewsapp.viewmodels.ScreenState

@Composable
fun HomeScreen() {
    val myViewModel = viewModel<MyViewModel>()
    val state = myViewModel.state

    val localUriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ) {
        //Date info card
        DateInfo(state)
        //Weather info card
        WeatherInfo(state)
        //News articles card
        NewsInfo(myViewModel, state, localUriHandler)
    }
}

@Composable
private fun NewsInfo(
    myViewModel: MyViewModel,
    state: ScreenState,
    localUriHandler: UriHandler
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { myViewModel.getUkNewsListVM() },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.uk_news_button_text),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = { myViewModel.getWorldNewsListVM() },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.world_news_button_text),
                    fontSize = 20.sp
                )
            }
        }
        HorizontalDivider(
            thickness = 2.dp,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        )
        LazyColumn(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 12.dp
                )
                .fillMaxHeight()
        ) {
            items(state.newsItems.size) {
                Text(
                    text = state.newsItems[it].webTitle,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                            localUriHandler.openUri(state.newsItems[it].webUrl)
                        }
                )
                HorizontalDivider(thickness = 2.dp)
            }
        }
    }
}

@Composable
private fun WeatherInfo(state: ScreenState) {
    Card(
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
                text = stringResource(R.string.today_s_weather_title),
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = state.weatherTempDegrees + stringResource(R.string.degrees_c),
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
}

@Composable
private fun DateInfo(state: ScreenState) {
    Card(
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
                text = stringResource(R.string.today_s_date_title),
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = state.dateInfo,
                fontSize = 36.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DailyNewsAppTheme {
        HomeScreen()
    }
}