package com.robelseyoum3.weekendexcercise.views.mainview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.NewsSource
import com.robelseyoum3.weekendexcercise.network.NewsRequest
import com.robelseyoum3.weekendexcercise.network.RetrofitInstances
import com.robelseyoum3.weekendexcercise.views.mainview.fragmentviews.MainFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()
    }

    private fun addFragment(){
        var fragmentManager = supportFragmentManager
        var fragmetTransaction = fragmentManager.beginTransaction()

        fragmetTransaction.add(R.id.fragment_container_from_main, MainFragment())
            //  .addToBackStack(null)
            .commit()
    }



}
