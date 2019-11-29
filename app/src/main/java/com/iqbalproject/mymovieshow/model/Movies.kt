package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class Movies (
    @SerializedName("id")
    val movieId: String? = null,

    @SerializedName("title")
    val movieTitle: String? = null,

    @SerializedName("overview")
    val movieOverview: String? = null,

    @SerializedName("release_date")
    val movieRelease: String? = null,

    @SerializedName("poster_path")
    val moviePoster: String? = null,

    @SerializedName("genre_ids")
    val movieGenre: List<String>
)