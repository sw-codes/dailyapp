package com.swright.dailynewsapp.data.retrofit

import com.swright.dailynewsapp.data.models.NewsData
import com.swright.dailynewsapp.data.models.WeatherData
import com.swright.dailynewsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    @GET("search?section=world&from-date=2024-07-18&to-date=2024-07-18&page-size=10&api-key=" +
//            Constants.GUARDIAN_NEWS_API_KEY
//    )
//    suspend fun getWorldNews(): Response<NewsList>

    @GET("search?section=world&")
    suspend fun getWorldNews(
        @Query("from-date") fromDate: String,
        @Query("to-date") toDate: String,
        @Query("page-size") pageSize: Int,
        @Query("api-key") apiKey: String
    ): Response<NewsData>

    @GET("search?section=uk-news&from-date=2024-07-18&to-date=2024-07-18&page-size=10&api-key=" +
            Constants.GUARDIAN_NEWS_API_KEY
    )
    suspend fun getUkNews(): Response<NewsData>

    @GET("current.json?")
    suspend fun getWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("aqi") aqi: String = "no"
    ): Response<WeatherData>
}