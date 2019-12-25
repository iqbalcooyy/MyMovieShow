package com.iqbalproject.mymovieshow.presenter

import android.util.Log
import com.google.gson.Gson
import com.iqbalproject.mymovieshow.model.TrailerMovieList
import com.iqbalproject.mymovieshow.utils.ApiRepository
import com.iqbalproject.mymovieshow.utils.EndPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TrailerPresenter(
    private val view: TrailerView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getDetailMovieList(movieId: String?) {
        GlobalScope.launch {
            val data = gson.fromJson(
                apiRepository.doRequest(EndPoint.getTrailerMovie(movieId)).await(),
                TrailerMovieList::class.java
            )

            Log.d("TRAILER_LIST", data.results.toString())

            view.showDetailsMovie(data.results)
        }
    }
}