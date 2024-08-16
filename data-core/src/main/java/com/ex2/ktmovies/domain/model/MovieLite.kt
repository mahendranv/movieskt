package com.ex2.ktmovies.domain.model

data class MovieLite(
    val id: String,
    val title: String,
    val rating: Double,
    val imageUrl: String?
)