package com.iqbalproject.mymovieshow.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iqbalproject.mymovieshow.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = intent.getStringExtra("title")
    }
}
