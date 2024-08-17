package com.ex2.ktmovies

import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieResult
import java.util.*

fun MovieDetails.prepareMeta(): String {
    val list = mutableListOf<Any>()
    releaseDate?.let { date ->
        list.add(date.get(Calendar.YEAR))
    }
    list.add(genre)

    if (runTime > 0) {
        val h = runTime / 60
        val m = runTime % 60
        var time = ""
        if (h > 0) {
            time = "$h${if (m == 0) "hours" else "h "}"
        }
        if (m > 0) {
            time += "${m}min"
        }
        list.add(time)
    }
    return list.joinToString(" | ")
}

fun MovieResult.prepareMeta(): String {
    val list = mutableListOf<Any>()
    releaseDate?.let { date ->
        list.add(date.get(Calendar.YEAR))
    }
    list.add(genres)

    if (runTime > 0) {
        val h = runTime / 60
        val m = runTime % 60
        var time = ""
        if (h > 0) {
            time = "$h${if (m == 0) "hours" else "h "}"
        }
        if (m > 0) {
            time += "${m}min"
        }
        list.add(time)
    }
    return list.joinToString(" | ")
}

fun MovieResult.ratingText(): String {
    val list = mutableListOf<Any>()
    if (rating > 0) {
        list.add(String.format("%.1f", rating))
        when {
            numberOfRatings >= 1000 -> list.add("${numberOfRatings / 1000}k")
            numberOfRatings > 0 -> list.add(numberOfRatings)
            else -> Unit
        }
    }
    return list.joinToString("/")
}