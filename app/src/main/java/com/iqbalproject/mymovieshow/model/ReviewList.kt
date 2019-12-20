package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class ReviewList (
    @SerializedName("results")
    val results: List<Review>
)