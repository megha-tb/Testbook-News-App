package com.example.testbook_news_app.repositories

enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}
class NewsListNetworkState(val status: Status, val msg: String) {

    companion object{
        val LOADED : NewsListNetworkState
        val LOADING : NewsListNetworkState
        val ERROR : NewsListNetworkState

        init{
            LOADED = NewsListNetworkState(Status.SUCCESS, "Success")
            LOADING = NewsListNetworkState(Status.RUNNING, "Loading")
            ERROR = NewsListNetworkState(Status.FAILED, "Something went wrong")

        }
    }
}