package com.ex2.ktmovies.domain.model

import java.util.*

data class MovieResult(
    val id: String,
    val title: String,
    val rating: Double,
    val imageUrl: String?,
    val overview: String,

    val genres: String,
    val releaseDate: Calendar?,
    val numberOfRatings: Int,
    val runTime: Int,
)