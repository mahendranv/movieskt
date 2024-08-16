package com.ex2.ktmovies.domain.model

import java.util.Calendar

data class MovieDetails(
    val id: String,
    val title: String,
    val rating: Double,
    val summary: String,

    val releaseDate: Calendar?,
    val runTime: Int,
    val genre: String,

    val covers: List<String>,
    val images: List<String>,

    val related: List<MovieLite>
)