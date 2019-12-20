package com.iqbalproject.mymovieshow.presenter

import com.google.gson.Gson
import com.iqbalproject.mymovieshow.model.ReviewList
import com.iqbalproject.mymovieshow.utils.ApiRepository
import com.iqbalproject.mymovieshow.utils.EndPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ReviewsPresenter(
    private val view: ReviewsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getReviewsMovie(movieId: String?) {
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository.doRequest(EndPoint.getReviewsMovie(movieId)).await(),
                ReviewList::class.java
            )

            view.showReviewList(data.results)
        }
    }
}