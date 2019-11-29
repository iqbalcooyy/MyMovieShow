package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName("id")
    val genreId: String? = null,

    @SerializedName("name")
    val genreName: String? = null
)