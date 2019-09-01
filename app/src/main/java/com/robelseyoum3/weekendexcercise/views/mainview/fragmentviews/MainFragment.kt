package com.robelseyoum3.weekendexcercise.views.mainview.fragmentviews


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.browser.customtabs.CustomTabsIntent


import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.ViewInterface
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.common.setBoldAndColorSpannable
import com.robelseyoum3.weekendexcercise.models.Articles
import com.robelseyoum3.weekendexcercise.models.NewsSource
import com.robelseyoum3.weekendexcercise.network.NewsRequest
import com.robelseyoum3.weekendexcercise.network.RetrofitInstances
import com.robelseyoum3.weekendexcercise.presenter.Presenter
import com.robelseyoum3.weekendexcercise.views.mainview.MainActivity
import kotlinx.android.synthetic.main.activity_news_row.*
import kotlinx.android.synthetic.main.fragment_main.*
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
class MainFragment : Fragment(), ViewInterface {
    private lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = Presenter(this)
        presenter.getTopNews()


    }

    override fun showLoading() {
        progress_id_main.visibility = View.VISIBLE

    }

    override fun showTopNews(news: NewsSource) {
        progress_id_main.visibility = View.GONE
        getNews(news)
    }

    private fun getNews(newsSource: NewsSource){

        val adapter = NewsAdapter(newsSource, object : onNewsClickListener {
            override fun newsURLClicked(news: Articles) {
                Log.d("getNews Attached url ", news.url)

                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                //customTabsIntent.launchUrl(activity?.applicationContext, Uri.parse(news.url))
                customTabsIntent.launchUrl(context, Uri.parse(news.url))

            }
        })

        rvList.layoutManager = LinearLayoutManager(activity?.applicationContext)
        rvList.adapter = adapter
    }


}

