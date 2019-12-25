package com.iqbalproject.mymovieshow.presenter

import android.util.Log
import com.google.gson.Gson
import com.iqbalproject.mymovieshow.model.GenreList
import com.iqbalproject.mymovieshow.utils.ApiRepository
import com.iqbalproject.mymovieshow.utils.EndPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GenresPresenter(
    private val view: GenresView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getGenreList(){
        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(
                apiRepository.doRequest(EndPoint.getGenres()).await(),
                GenreList::class.java
            )

            Log.d("GENRE_LIST", data.genres.toString())

            view.showGenreList(data.genres)
        }
    }
}