package com.swright.dailynewsapp.viewmodels

import com.swright.dailynewsapp.data.models.NewsList
import com.swright.dailynewsapp.utils.Constants
import com.swright.dailynewsapp.utils.RetrofitInstance
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Repository {

    suspend fun getWorldNewsList(): Response<NewsList> {
        val currentDate = SimpleDateFormat("yyyy-M-dd", Locale.ROOT).format(Date())
        println(currentDate)
        return RetrofitInstance.api.getWorldNews(
            fromDate = currentDate,
            toDate = currentDate,
            pageSize = 10,
            apiKey = Constants.GUARDIAN_NEWS_API_KEY
        )

    }

    suspend fun getUkNewsList(): Response<NewsList> {
        return RetrofitInstance.api.getUkNews()
    }
}