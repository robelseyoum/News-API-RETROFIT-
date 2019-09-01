package com.robelseyoum3.weekendexcercise.views.mainview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.views.mainview.fragmentviews.MainFragment


class MainActivity : AppCompatActivity(){

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
