package com.swright.dailynewsapp.viewmodels

import com.swright.dailynewsapp.data.models.NewsData
import com.swright.dailynewsapp.data.models.WeatherData
import com.swright.dailynewsapp.utils.Constants
import com.swright.dailynewsapp.utils.NewsRetrofitInstance
import com.swright.dailynewsapp.utils.WeatherRetrofitInstance
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Repository {

    val currentDate = SimpleDateFormat("yyyy-M-dd", Locale.ROOT).format(Date())

    suspend fun getWorldNewsList(): Response<NewsData> {
        return NewsRetrofitInstance.api.getWorldNews(
            fromDate = currentDate,
            toDate = currentDate,
            pageSize = 10,
            apiKey = Constants.GUARDIAN_NEWS_API_KEY
        )
    }

    suspend fun getUkNewsList(): Response<NewsData> {
        return NewsRetrofitInstance.api.getUkNews(
            fromDate = currentDate,
            toDate = currentDate,
            pageSize = 10,
            apiKey = Constants.GUARDIAN_NEWS_API_KEY
        )
    }

    suspend fun getWeather(): Response<WeatherData> {
        return WeatherRetrofitInstance.api.getWeather(
            apiKey = Constants.WEATHER_API_KEY,
            location = Constants.LOCATION_LAT_LONG,
            aqi = "no",
        )
    }
}