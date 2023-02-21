package com.example.testbook_news_app

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.testbook_news_app.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    companion object{
        const val news_EXTRA = "news_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getBundleExtra(news_EXTRA)
        var img : ImageView = binding.newsimg
        Glide.with(img).load(name?.getString("image")).into(img)
        binding.newstit.text = name?.getString("title")
        binding.newssrc.text = name?.getString("publishedAt")
        binding.newsdesc.text = name?.getString("description")

    }
}

