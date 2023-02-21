package com.example.testbook_news_app.adapter

import androidx.recyclerview.widget.DiffUtil

class NewsListDiffCallback : DiffUtil.ItemCallback<Any>() {

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }
}