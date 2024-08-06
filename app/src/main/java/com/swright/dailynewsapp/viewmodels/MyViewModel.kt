package com.swright.dailynewsapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swright.dailynewsapp.data.models.Result
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MyViewModel: ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())

    init {
        getUkNewsListVM()
        getWeatherVM()
        getDate()
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

    private fun getDate(){
        viewModelScope.launch {
            val dateOfMonth = SimpleDateFormat("d", Locale.getDefault()).format(Date()).toString()
            val datePatterString: String
            when (dateOfMonth.last()) {
                '1' -> datePatterString = "E, d'st of' MMMM"
                '2' -> datePatterString = "E, d'nd of' MMMM"
                '3' -> datePatterString = "E, d'rd of' MMMM"
                else -> datePatterString = "E, d'th of' MMMM"
            }
            val todayDate = SimpleDateFormat(datePatterString, Locale.getDefault()).format(Date()).toString()
            state = state.copy(
                dateInfo = todayDate
            )
        }

    }
}

data class ScreenState(
    val newsItems: List<Result> = emptyList(),
    val weatherText: String = "",
    val weatherTempDegrees: String = "",
    val dateInfo: String = ""
)