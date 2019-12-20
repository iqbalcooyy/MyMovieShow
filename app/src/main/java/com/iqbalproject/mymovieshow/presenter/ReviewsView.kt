package com.iqbalproject.mymovieshow.presenter

import com.iqbalproject.mymovieshow.model.Review

interface ReviewsView {
    fun showReviewList(data: List<Review>)
}