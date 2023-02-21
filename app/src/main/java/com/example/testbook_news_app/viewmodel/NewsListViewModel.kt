package com.example.testbook_news_app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testbook_news_app.model.NewsModel
import com.example.testbook_news_app.repositories.NewsListRepo
import com.example.testbook_news_app.model.Result
import kotlinx.coroutines.launch

class NewsListViewModel : ViewModel() {
    val newsRepo = NewsListRepo()
    val newsList: MutableLiveData<List<Result>> = MutableLiveData()

    fun getNewsList() {
        viewModelScope.launch {
            try {
                println("viewmodel")
                val response = newsRepo.fetchNewsData()
                Log.d("response", response.toString()
                )
                if (response != null) {
                    onGetNewsListResponseSuccess(response)
                    println(newsList)
                }
            } catch (e: Exception) {

            }
        }
    }

    fun onGetNewsListResponseSuccess(response: NewsModel) {
        newsList.value = response.articles
    }
}