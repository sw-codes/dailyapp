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

class NewsViewModel: ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())

    init {
        getUkNewsListVM()
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
}

data class ScreenState(
    val newsItems: List<Result> = emptyList()
)