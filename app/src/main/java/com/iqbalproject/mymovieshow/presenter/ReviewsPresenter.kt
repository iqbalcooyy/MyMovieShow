package com.iqbalproject.mymovieshow.presenter

import android.content.Context
import android.util.Log
import android.widget.Toast
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
    fun getReviewsMovie(context: Context, movieId: String?) {
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository.doRequest(EndPoint.getReviewsMovie(movieId)).await(),
                ReviewList::class.java
            )

            Log.d("REVIEWS", data.results.toString())

            if (!data.results.isEmpty()) {
                view.showReviewList(data.results)
            } else {
                Toast.makeText(context, "Review isn't Available", Toast.LENGTH_SHORT).show()
            }

        }
    }
}