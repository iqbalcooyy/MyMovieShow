package com.iqbalproject.mymovieshow.presenter

import com.iqbalproject.mymovieshow.model.TrailerMovie

interface TrailerView {
    fun showDetailsMovie(data: List<TrailerMovie>)
}