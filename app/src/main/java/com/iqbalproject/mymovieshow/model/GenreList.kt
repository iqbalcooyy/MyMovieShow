package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class GenreList(
    @SerializedName("genres")
    val genres: List<Genres>
)