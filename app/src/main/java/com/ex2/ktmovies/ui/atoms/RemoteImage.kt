package com.ex2.ktmovies.ui.atoms

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ex2.droid.R

@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    url: String?,
    @DrawableRes
    placeHolder: Int = R.drawable.ic_movie_placeholder,
    contentDescription: String = ""
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(placeHolder),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier//.clip(CircleShape)
    )
}