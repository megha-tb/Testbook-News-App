package com.example.testbook_news_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbook_news_app.R
import com.example.testbook_news_app.databinding.CardBinding
//import com.bumptech.glide.annotation.GlideModule
//import com.bumptech.glide.module.AppGlideModule
//import kotlin.Result

class NewsListViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object{
        fun create(inflater: LayoutInflater,
                   viewGroup: ViewGroup
        ) : NewsListViewHolder {
            val binding = DataBindingUtil.inflate<CardBinding>(inflater, R.layout.card , viewGroup ,false)
            return NewsListViewHolder(binding)
        }
    }

    private val photo: ImageView = binding.newsImage

    fun bind(news: com.example.testbook_news_app.model.Result) {
        print("Bind")

        val author = "Author: "+news.author
        val title = "Title: "+news.title

        binding.newsAuthor.text = author
        binding.newsTitle.text = title

        Glide.with(photo).load(news.urlToImage).into(photo)



    }
}