package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class MovieList (
    @SerializedName("results")
    val results: List<Movies>
)