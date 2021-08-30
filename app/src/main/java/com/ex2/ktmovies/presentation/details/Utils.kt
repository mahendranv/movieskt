package com.ex2.ktmovies.presentation.details

import com.ex2.ktmovies.domain.model.MovieDetails
import java.util.*

fun MovieDetails.prepareMeta(): String {

    val list = mutableListOf<Any>()
    if (releaseDate != null) {
        list.add(releaseDate.get(Calendar.YEAR))
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