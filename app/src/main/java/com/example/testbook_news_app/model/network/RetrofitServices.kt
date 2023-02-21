package com.example.testbook_news_app.model.network
import com.example.testbook_news_app.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("now_playing")
    suspend fun getNews(@Query("apiKey") key1: String, @Query("q") key2: String): NewsModel

}