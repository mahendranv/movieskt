package com.ex2.ktmovies.domain.model

data class MovieDetails(
    val id: String,
    val title: String,
    val rating: Double,
    val summary: String,

    val covers: List<String>,
    val images: List<String>,

    val related: List<MovieLite>
)