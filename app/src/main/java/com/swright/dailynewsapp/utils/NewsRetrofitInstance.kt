package com.swright.dailynewsapp.utils

import com.swright.dailynewsapp.data.retrofit.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofitInstance {
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BaseNewsUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}