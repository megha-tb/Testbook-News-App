package com.example.testbook_news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replacefragment()
    }

    private fun replacefragment() {

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, MainFragment.newInstance()).commitNow()

    }


}