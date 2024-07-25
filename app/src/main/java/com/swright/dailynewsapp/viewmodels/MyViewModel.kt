package com.swright.dailynewsapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swright.dailynewsapp.data.models.Result
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())

    init {
        getUkNewsListVM()
        getWeatherVM()
    }

    fun getWorldNewsListVM() {
        viewModelScope.launch {
            val response = repository.getWorldNewsList()
            state = state.copy(
                newsItems = response.body()!!.response.results
            )
        }
    }

    fun getUkNewsListVM() {
        viewModelScope.launch {
            val response = repository.getUkNewsList()
            state = state.copy(
                newsItems = response.body()!!.response.results
            )
        }
    }

    private fun getWeatherVM() {
        viewModelScope.launch {
            val response = repository.getWeather()
            state = state.copy(
                weatherText = response.body()!!.current.condition.text,
                weatherTempDegrees = response.body()!!.current.temp_c.toString()
            )
        }
    }
}

data class ScreenState(
    val newsItems: List<Result> = emptyList(),
    val weatherText: String = "",
    val weatherTempDegrees: String = ""
)