package com.iqbalproject.mymovieshow.presenter

import com.iqbalproject.mymovieshow.model.Genres

interface GenresView {
    fun showGenreList(data: List<Genres>)
}