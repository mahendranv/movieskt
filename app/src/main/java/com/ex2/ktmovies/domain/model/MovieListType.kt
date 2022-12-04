package com.ex2.ktmovies.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class MovieListType : Parcelable{
    NOW_PLAYING,
    TRENDING,
    TOP_RATED
}