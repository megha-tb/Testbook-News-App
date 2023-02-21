package com.example.testbook_news_app.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitClient {

    public fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/docs/endpoints/everything/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
