package com.example.at_marvel_movie.model

import android.media.Image

class Series(
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val resourceURI: String? = null,
    val startYear: Int? = null,
    val endYear: Int? = null,
    val thumbnail: Image? = null,
)