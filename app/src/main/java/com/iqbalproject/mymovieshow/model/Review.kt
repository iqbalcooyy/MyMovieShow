package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class Review (
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("author")
    val author: String? = null,

    @SerializedName("content")
    val comment: String? = null
)