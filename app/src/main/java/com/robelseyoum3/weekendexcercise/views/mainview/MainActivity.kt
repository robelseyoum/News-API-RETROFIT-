package com.robelseyoum3.weekendexcercise.views.mainview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.NewsSource
import com.robelseyoum3.weekendexcercise.network.NewsRequest
import com.robelseyoum3.weekendexcercise.network.RetrofitInstances
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRequest = RetrofitInstances().retrofitInstances.create(NewsRequest::class.java)

        val call = newsRequest.getNews(Constants.COUNTRY, Constants.API_KEY)

        call.enqueue(object : Callback<NewsSource>{

            override fun onFailure(call: Call<NewsSource>, t: Throwable) {
                Log.d("News Error ", ""+t.message)

            }

            override fun onResponse(call: Call<NewsSource>, response: Response<NewsSource>) {
                val res = response.body()
                Log.d("Title ", res!!.articles[0].author)
            }

//https://newsapi.org/v2/top-headlines?country=us&apiKey=9965f6d322474e2c93a08da812d621d6
//https://newsapi.org/v2/top-headlines?country=us&api_key=9965f6d322474e2c93a08da812d621d6
//https://newsapi.org/v2/top-headlines?country=us&apiKey=9965f6d322474e2c93a08da812d621d6
//https://newsapi.org/v2/top-headlines?country=us&apikey=9965f6d322474e2c93a08da812d621d6

        })


    }
}
