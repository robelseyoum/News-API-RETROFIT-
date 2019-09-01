package com.robelseyoum3.weekendexcercise

import com.robelseyoum3.weekendexcercise.models.NewsSource

interface ViewInterface {

    fun showLoading()
    fun showTopNews(news: NewsSource)

}