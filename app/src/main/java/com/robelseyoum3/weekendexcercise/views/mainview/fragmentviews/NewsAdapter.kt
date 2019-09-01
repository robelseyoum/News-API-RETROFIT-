package com.robelseyoum3.weekendexcercise.views.mainview.fragmentviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.models.Articles
import com.robelseyoum3.weekendexcercise.models.NewsSource
import kotlinx.android.synthetic.main.activity_news_row.view.*

class NewsAdapter(private val newSource: NewsSource, private val listener: onNewsClickListener)
    : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_news_row, parent, false))
    }

    override fun getItemCount(): Int {
        return newSource.articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        //Log.i("Title ", ""+res!!.articles[1].title)
        holder.tvAuthor.text = newSource.articles[position].author
        holder.tvTitle.text = newSource.articles[position].title
        holder.tvDescription.text = newSource.articles[position].description

        holder.bind(newSource.articles[position], listener)
    }


    class NewsViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val tvTitle = view.tv_title
        val tvAuthor = view.tv_author
        val tvDescription = view.tv_description

        fun bind(url: Articles, listener: onNewsClickListener){
            itemView.setOnClickListener {
                listener.newsURLClicked(url)
            }
        }

    }
}

interface onNewsClickListener{
    fun newsURLClicked(news: Articles)
}