package com.example.testbook_news_app.repositories

import androidx.lifecycle.MutableLiveData
import com.example.testbook_news_app.model.NewsModel
import com.example.testbook_news_app.model.network.RetrofitClient
import com.example.testbook_news_app.model.network.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class NewsListRepo {
    private val _networkState = MutableLiveData<NewsListNetworkState>()
    val _NewsListResponse = MutableLiveData<NewsModel>()

    suspend fun fetchNewsData(): NewsModel {
        val retrofit = RetrofitClient().getInstance()
        val request = retrofit.create(RetrofitServices::class.java)

        return withContext(Dispatchers.IO) {
            val async = async {
                request.getNews("3f970b3b09d04f4ea3d5c3b676d6e84f", key2 = "australia")
            }

            val NewsListResponse = async.await()
            NewsListResponse
        }
    }
}

