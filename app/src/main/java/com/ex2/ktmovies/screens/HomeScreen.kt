package com.ex2.ktmovies.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import com.ex2.ktmovies.viewmodels.MovieListViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieListViewModel = hiltViewModel() // viewModel(modelClass = MovieListViewModel::class)
) {
    val pageState = viewModel.pageState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchList()
    }

    when (val state = pageState.value) {
        MovieListViewModel.PageState.Loading -> {

        }

        MovieListViewModel.PageState.Error -> {

        }

        is MovieListViewModel.PageState.Loaded -> {
            MovieListUi(modifier = modifier, state.list)
        }
    }
}
