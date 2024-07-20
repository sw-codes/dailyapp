package com.swright.dailynewsapp.data.retrofit

import com.swright.dailynewsapp.data.models.NewsList
import com.swright.dailynewsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
    ): Response<NewsList>

    @GET("search?section=uk-news&from-date=2024-07-18&to-date=2024-07-18&page-size=10&api-key=" +
            Constants.GUARDIAN_NEWS_API_KEY
    )
    suspend fun getUkNews(): Response<NewsList>
}