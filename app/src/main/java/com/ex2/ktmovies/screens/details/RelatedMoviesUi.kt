package com.ex2.ktmovies.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.data.fake.FakeData
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import com.ex2.ktmovies.ui.widgets.MovieCard2

@Composable
fun RelatedMoviesUi(
    modifier: Modifier = Modifier,
    contentPadding: Dp = 16.dp,
    movies: List<MovieLite>,
    onItemClicked: (String) -> Unit = {}
) {
    LazyHorizontalGrid(
        modifier = modifier,
        contentPadding = PaddingValues(contentPadding),
        rows = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(movies, key = { it.id }) { movie ->
            MovieCard2(
                movie = movie,
                modifier = Modifier.clickable {
                    onItemClicked(movie.id)
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewRelatedMoviesUi() {
    KtMoviesTheme {
        Surface {
            RelatedMoviesUi(movies = FakeData.movieList)
        }
    }
}