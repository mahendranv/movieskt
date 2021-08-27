package com.ex2.ktmovies.common.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load
import com.ex2.ktmovies.R

/**
 * Wrapper extension to load image
 */
fun ImageView.loadImage(
    url: String?,
    @DrawableRes placeHolder: Int = R.drawable.ic_movie_placeholder,
    @DrawableRes fallback: Int = R.drawable.ic_movie_placeholder,
) {
    if (url.isNullOrBlank()) {
        load(fallback)
    } else {
        load(url) {
            crossfade(true)
            fallback(fallback)
            placeholder(placeHolder)
        }
    }
}