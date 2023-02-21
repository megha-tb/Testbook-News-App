package com.example.testbook_news_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testbook_news_app.R

class NewsListAdapter() : ListAdapter<Any, RecyclerView.ViewHolder>(NewsListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        var viewHolder : RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when(viewType){
            R.layout.card -> viewHolder = NewsListViewHolder.create(inflater, parent)
        }
        return  (viewHolder as NewsListViewHolder?)!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is NewsListViewHolder -> holder.bind(item as com.example.testbook_news_app.model.Result)
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = getItem(position)
        var itemViewType = 0
        when(item){
            is com.example.testbook_news_app.model.Result -> itemViewType = R.layout.card
        }
        return itemViewType
    }

    public override fun getItem(position: Int): Any {
        return super.getItem(position)
    }


}