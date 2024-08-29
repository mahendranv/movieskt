package com.ex2.ktmovies.screens

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.data.fake.FakeData
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import com.ex2.ktmovies.ui.widgets.MovieCard2

@Composable
fun MovieListUi(
    modifier: Modifier = Modifier,
    list: List<MovieLite>,
    itemClick: (String) -> Unit = { }
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list, key = { it.id }) { movie ->
            MovieCard2(
                movie = movie,
                modifier = Modifier.clickable {
                    itemClick(movie.id)
                })
        }
    }
}

@Preview(device = Devices.NEXUS_6, showBackground = true)
@Preview(device = Devices.NEXUS_6, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MovieListUiPreview() {
    KtMoviesTheme {
        MovieListUi(list = FakeData.movieList)
    }
}