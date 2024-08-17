package com.ex2.ktmovies.common.extensions

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.ex2.droid.R


fun ImageView.loadSvg(url: String) {
    val request = ImageRequest.Builder(this.context).data(Uri.parse(url)).target(this).build()
    val imageLoader = ImageLoader.Builder(context).components {
        add(SvgDecoder.Factory())
    }.build()
    imageLoader.enqueue(request)
}

/**
 * Wrapper extension to load image
 */
fun ImageView.loadImage(
    url: String?,
    @DrawableRes placeHolder: Int = R.drawable.ic_movie_placeholder,
    @DrawableRes fallback: Int = R.drawable.ic_movie_placeholder,
    cornerRadius: Int = 0
) {
    if (url.isNullOrBlank()) {
        load(fallback)
    } else {
        load(url) {
            crossfade(true)
            fallback(fallback)
            placeholder(placeHolder)
            if (cornerRadius > 0) {
                transformations(RoundedCornersTransformation(cornerRadius.toFloat()))
            }
        }
    }
}