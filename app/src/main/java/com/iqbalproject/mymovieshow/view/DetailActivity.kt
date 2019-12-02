package com.iqbalproject.mymovieshow.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.iqbalproject.mymovieshow.R
import com.iqbalproject.mymovieshow.model.Movies
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var detailFragment: Fragment
    private var data = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie: Movies = intent.getParcelableExtra("movie")

        supportActionBar?.title = movie.movieTitle

        val overview = R.id.overview
        val review = R.id.review

        bottomBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                overview -> {
                    data.putString("overview", movie.movieOverview)
                    data.putString("movieId", movie.movieId)
                    detailFragment = OverviewFragment()
                    detailFragment.arguments = data
                }
            }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.detailContainer, detailFragment, OverviewFragment::class.java.simpleName)
                .commit()

            true
        }

        bottomBar.selectedItemId = overview
    }
}
