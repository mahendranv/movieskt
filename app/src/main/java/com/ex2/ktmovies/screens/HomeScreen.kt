package com.ex2.ktmovies.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ex2.ktmovies.R
import com.ex2.ktmovies.nav.DetailsDestination
import com.ex2.ktmovies.nav.SearchDestination
import com.ex2.ktmovies.ui.atoms.FullScreenText
import com.ex2.ktmovies.ui.atoms.LoadingProgress
import com.ex2.ktmovies.viewmodels.MovieListViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, navController: NavController, viewModel: MovieListViewModel = hiltViewModel()
) {
    val pageState = viewModel.pageState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchList()
    }

    Scaffold(
        modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(SearchDestination)
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_white_24dp),
                    contentDescription = stringResource(id = R.string.search)
                )
            }
        }
    ) { padding ->
        when (val state = pageState.value) {
            MovieListViewModel.PageState.Loading -> {
                LoadingProgress()
            }

            MovieListViewModel.PageState.Error -> {
                FullScreenText(text = "Cannot load content")
            }

            is MovieListViewModel.PageState.Loaded -> {
                MovieListUi(
                    modifier = Modifier.padding(padding), list = state.list
                ) { movieId ->
                    navController.navigate(DetailsDestination(id = movieId))
                }
            }
        }
    }
}
