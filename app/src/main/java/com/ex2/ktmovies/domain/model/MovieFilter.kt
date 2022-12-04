package com.ex2.ktmovies.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MovieFilter(

    /**
     * Movie listing type
     * Movie listing type
     */
    var listType: MovieListType? = null
) : Parcelable