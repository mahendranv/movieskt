package com.ex2.ktmovies.data.tmdb

import android.annotation.SuppressLint
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import info.movito.themoviedbapi.model.MovieDb
import java.text.SimpleDateFormat
import java.util.Calendar

fun MovieDb.toMovieDetails(): MovieDetails = MovieDetails(
    id = this.id.toString(),
    title = title,
    rating = voteAverage.toDouble(),
    summary = this.overview,
    releaseDate = parseDate(this.releaseDate),
    runTime = runtime,
    genre = genres.firstOrNull()?.name ?: "",
    covers = listOf(this.backdropPath),
    images = this.getImages().mapNotNull { it.filePath.inDetailsResolution() },
    related = this.similarMovies.map { it.toMovieLite() }
)

fun MovieDb.toMovieLite(): MovieLite = MovieLite(
    id = this.id.toString(),
    title = this.title,
    rating = this.voteAverage.toDouble(),
    imageUrl = this.posterPath.inListingResolution()
)

fun MovieDb.toMovieResult(): MovieResult = MovieResult(
    id = this.id.toString(),
    title = this.title,
    rating = this.voteAverage.toDouble(),
    imageUrl = this.posterPath.inListingResolution(),
    overview = this.overview,
    genres = this.genres?.take(2)?.joinToString { ", " } ?: "",
    releaseDate = parseDate(this.releaseDate),
    numberOfRatings = this.voteCount,
    runTime = this.runtime
)

@SuppressLint("SimpleDateFormat")
private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd")

//2022-10-28
private fun parseDate(date: String?): Calendar? = try {
    val parsed = DATE_FORMAT.parse(date!!)
    Calendar.getInstance().apply {
        time = parsed!!
    }
} catch (e: Exception) {
    null
}

private fun String?.inListingResolution(): String? {
    return if (this == null) null else "https://image.tmdb.org/t/p/w300$this"
}

private fun String?.inDetailsResolution(): String? {
    return if (this == null) null else "https://image.tmdb.org/t/p/w500$this"
}