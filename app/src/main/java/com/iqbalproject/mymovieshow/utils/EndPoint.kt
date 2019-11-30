package com.iqbalproject.mymovieshow.utils

import android.net.Uri
import com.iqbalproject.mymovieshow.BuildConfig

object EndPoint {

    fun getGenres(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("3")
            .appendPath("genre")
            .appendPath("movie")
            .appendPath("list")
            .appendQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
            .toString()
    }

    fun getMovies(genreId: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("3")
            .appendPath("discover")
            .appendPath("movie")
            .appendQueryParameter("with_genres", genreId)
            .appendQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
            .toString()
    }
}