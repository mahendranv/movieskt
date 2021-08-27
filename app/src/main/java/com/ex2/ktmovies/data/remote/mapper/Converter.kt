package com.ex2.ktmovies.data.remote.mapper

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