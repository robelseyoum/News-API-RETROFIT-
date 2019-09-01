package com.robelseyoum3.weekendexcercise.presenter

import android.net.Uri
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.robelseyoum3.weekendexcercise.PresenterInterface
import com.robelseyoum3.weekendexcercise.ViewInterface
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.Articles
import com.robelseyoum3.weekendexcercise.models.NewsSource
import com.robelseyoum3.weekendexcercise.network.NewsRequest
import com.robelseyoum3.weekendexcercise.network.RetrofitInstances
import com.robelseyoum3.weekendexcercise.views.mainview.fragmentviews.NewsAdapter
import com.robelseyoum3.weekendexcercise.views.mainview.fragmentviews.onNewsClickListener
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(_view: ViewInterface): PresenterInterface {

    private var view: ViewInterface? = _view
    private lateinit var model: NewsSource

    override fun getTopNews() {
        makeRetrofitCall()

    }

    private fun makeRetrofitCall(){

        val newsRequest = RetrofitInstances().retrofitInstances.create(NewsRequest::class.java)
        val call = newsRequest.getNews(Constants.COUNTRY, Constants.API_KEY)
        call.enqueue(object : Callback<NewsSource> {

            override fun onFailure(call: Call<NewsSource>, t: Throwable) {
                Log.d("News Error ", ""+t.message)
            }

            override fun onResponse(call: Call<NewsSource>, response: Response<NewsSource>) {
                val res = response.body()
                //Log.i("Title ", ""+res!!.articles[1].title)
                view!!.showTopNews(res!!)
            }

        })
    }

    override fun onDestroy() {
        view = null
    }
}