package com.ex2.ktmovies.data.remote.mapper

import com.ex2.ktmovies.MovieDetailsQuery
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.fragment.GMovieLite

fun GMovieLite.toDomainModel(): MovieLite {
    return MovieLite(
        id = node?.id ?: "",
        title = node?.title ?: "",
        rating = node?.rating ?: 0.0,
        imageUrl = node?.images?.posters?.firstOrNull()?.image?.toString()
    )
}

fun MovieDetailsQuery.AsMovie.toDomainModel(): MovieDetails {
    return MovieDetails(
        id = id,
        title = title,
        summary = overview,
        rating = rating,
        related = similar.edges?.filterNotNull()?.map { it.fragments.gMovieLite.toDomainModel() }
            ?: emptyList()
    )
}
