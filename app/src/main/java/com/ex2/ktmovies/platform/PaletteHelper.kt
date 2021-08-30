package com.ex2.ktmovies.platform

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.size.Scale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Dispatches palette creation to IO dispatcher given an image url.
 */
suspend fun pickPalette(context: Context, url: String) = withContext(Dispatchers.IO) {
    val request = ImageRequest.Builder(context)
        .data(url)
        .size(100)
        .build()

    val drawable = ImageLoader(context)
        .execute(request)
        .drawable

    var palette: Palette? = null
    (drawable as? BitmapDrawable)?.bitmap?.let {
        val mutable = it.copy(Bitmap.Config.ARGB_8888, true)
        palette = Palette.from(mutable).generate()
    }
    palette
}