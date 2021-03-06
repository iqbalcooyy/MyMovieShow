package com.iqbalproject.mymovieshow.presenter

import android.util.Log
import com.google.gson.Gson
import com.iqbalproject.mymovieshow.model.MovieList
import com.iqbalproject.mymovieshow.utils.ApiRepository
import com.iqbalproject.mymovieshow.utils.EndPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoviesPresenter(private val view: MoviesView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson
) {
    fun getMovieList(genreId: String?){
        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(
                apiRepository.doRequest(EndPoint.getMovies(genreId)).await(),
                MovieList::class.java
            )

            Log.d("MOVIE_LIST", data.results.toString())

            view.showMovieList(data.results)
        }
    }
}