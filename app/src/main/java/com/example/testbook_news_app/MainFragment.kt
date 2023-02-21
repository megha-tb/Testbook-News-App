package com.example.testbook_news_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testbook_news_app.adapter.NewsListAdapter
import com.example.testbook_news_app.viewmodel.NewsListViewModel
import com.example.testbook_news_app.model.Result
import com.example.testbook_news_app.viewmodel.NewsListViewModelFactory


// TODO: Rename parameter arguments, choose names that match

class MainFragment : Fragment() {

    companion object {

        fun newInstance() = MainFragment().apply {

        }
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

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
        initViewModel()
        initData()
        initViewModelObserver()
        initAdapter()
    }

    private lateinit var viewModel : NewsListViewModel
    private fun initData() {
        viewModel.getNewsList()
    }

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val newsAdapter = NewsListAdapter()

    private fun initAdapter() {
        linearLayoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
        val recv= view?.findViewById<RecyclerView>(R.id.recyclerView)
        recv?.adapter = newsAdapter
        recv?.layoutManager = linearLayoutManager
    }

    private fun initViewModelObserver() {
        viewModel.newsList.observe(viewLifecycleOwner, {
            onGetNewsListResponse(it)
        })
    }

    private fun onGetNewsListResponse(resultResponse: List<Result>?) {
        if (resultResponse != null) {
            adapterListSubmit(resultResponse)
        }
    }

    private lateinit var data : ArrayList<*>
    private fun adapterListSubmit(resultResponse: List<Result>) {
        data = resultResponse as ArrayList<*>
        println(data[0])
        newsAdapter.submitList(data)
    }

    private fun initViewModel(){
        @Suppress("DEPRECATION")
        viewModel = ViewModelProviders.of(this , NewsListViewModelFactory())
                 .get(NewsListViewModel::class.java)
    }

}

