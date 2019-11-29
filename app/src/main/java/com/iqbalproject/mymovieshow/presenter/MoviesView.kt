package com.iqbalproject.mymovieshow.presenter

import com.iqbalproject.mymovieshow.model.Movies

interface MoviesView {
    fun showMovieList(data: List<Movies>)
}