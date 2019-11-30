package com.iqbalproject.mymovieshow.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.iqbalproject.mymovieshow.BuildConfig
import com.iqbalproject.mymovieshow.R
import com.iqbalproject.mymovieshow.model.Movies
import com.squareup.picasso.Picasso

class MovieAdapter(private val context: Context, private val movies: List<Movies>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var mView = convertView
        var imgPoster: ImageView
        var tvTitle: TextView
        var tvReleaseDate: TextView

        if (mView == null) {
            val inflater = (context as Activity).layoutInflater
            mView = inflater.inflate(R.layout.movie, parent, false)
        }

        imgPoster = mView!!.findViewById(R.id.imgPoster)
        tvTitle = mView!!.findViewById(R.id.tvMovieName)
        tvReleaseDate = mView!!.findViewById(R.id.tvReleaseDate)

        Picasso.get().load(BuildConfig.POSTER_MOVIE_URL + movies.get(position).moviePoster).into(imgPoster)
        tvTitle.text = movies.get(position).movieTitle
        tvReleaseDate.text = movies.get(position).movieRelease

        return mView
    }

    override fun getItem(p0: Int): Any {
        return movies.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return movies.size
    }
}