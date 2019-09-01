package com.robelseyoum3.weekendexcercise.views.mainview.fragmentviews


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.NewsSource
import com.robelseyoum3.weekendexcercise.network.NewsRequest
import com.robelseyoum3.weekendexcercise.network.RetrofitInstances
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                Log.i("Title ", ""+res!!.articles[1].title)
            }

        })
    }


}
