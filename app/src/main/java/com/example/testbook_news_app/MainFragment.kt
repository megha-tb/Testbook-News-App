package com.example.testbook_news_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testbook_news_app.R.layout.fragment_main
import com.example.testbook_news_app.adapter.NewsListAdapter

// TODO: Rename parameter arguments, choose names that match

class MainFragment : Fragment() {

    companion object {

        fun newInstance() = MainFragment().apply {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initAdapter()
    }

    private lateinit var linearLayoutManager: LinearLayoutManager
    val newsAdapter = NewsListAdapter()

    private fun initAdapter() {
        linearLayoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
        val recv= view?.findViewById<RecyclerView>(R.id.recyclerView)
        recv?.adapter = newsAdapter
        recv?.layoutManager = linearLayoutManager
    }


}

