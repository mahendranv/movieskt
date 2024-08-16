package com.ex2.ktmovies.presentation.list

import android.content.Context
import android.widget.ArrayAdapter
import androidx.annotation.StringRes
import com.ex2.ktmovies.domain.model.MovieListType

data class MovieSection(
    @StringRes
    val stringId: Int,
    val movieSection: MovieListType
)

val sections = listOf(
    MovieSection(stringId = com.ex2.ktmovies.R.string.type_now_playing, MovieListType.NOW_PLAYING),
    MovieSection(stringId = com.ex2.ktmovies.R.string.type_top_rated, MovieListType.TOP_RATED),
    MovieSection(stringId = com.ex2.ktmovies.R.string.type_trending, MovieListType.TRENDING)
)

class MovieTypeAdapter(context: Context) :
    ArrayAdapter<MovieSection>(context, android.R.layout.simple_list_item_1) {

    override fun getItem(position: Int): MovieSection? {
        return super.getItem(position)
    }

}