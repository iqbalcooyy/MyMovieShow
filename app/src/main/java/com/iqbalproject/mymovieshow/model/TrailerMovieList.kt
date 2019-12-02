package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class TrailerMovieList (
    @SerializedName("results")
    val results: List<TrailerMovie>
)