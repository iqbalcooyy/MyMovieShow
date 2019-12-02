package com.iqbalproject.mymovieshow.model

import com.google.gson.annotations.SerializedName

data class TrailerMovie (
    @SerializedName("id")
    val videoId: String? = null,

    @SerializedName("key")
    val videoKey: String? = null,

    @SerializedName("name")
    val videoName: String? = null,

    @SerializedName("type")
    val videoType: String? = null
)