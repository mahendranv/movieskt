package com.ex2.ktmovies.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ex2.ktmovies.data.fake.FakeData
import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.ui.theme.KtMoviesTheme

@Preview
@Composable
private fun PreviewSearchListUi() {
    KtMoviesTheme {
        SearchListUi(list = FakeData.searchResults)
    }
}

@Composable
fun SearchListUi(
    modifier: Modifier = Modifier, list: List<MovieResult>,
    onItemClicked: (String) -> Unit = {}
) {
    Surface(modifier = modifier) {
        LazyColumn {
            items(list, key = { it.id }) { result ->
                SearchListItem(result = result, modifier = Modifier.clickable {
                    onItemClicked(result.id)
                })
            }
        }
    }
}

