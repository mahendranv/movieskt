package com.ex2.ktmovies.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ex2.ktmovies.nav.DetailsDestination
import com.ex2.ktmovies.ui.atoms.FullScreenText
import com.ex2.ktmovies.ui.atoms.LoadingProgress
import com.ex2.ktmovies.viewmodels.MovieDetailsViewModel

@Composable
fun DetailsScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val pageState = viewModel.pageState.collectAsState()

    // Fetch
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchMovieDetails(id)
    }

    when (val data = pageState.value) {
        is MovieDetailsViewModel.PageState.Initial -> {
            LoadingProgress()
        }

        is MovieDetailsViewModel.PageState.Error -> {
            FullScreenText(text = data.error)
        }

        is MovieDetailsViewModel.PageState.Loaded -> {
            DetailsScreenUi(
                details = data.details,
                modifier = modifier,
            ) { relatedMovieId ->
                navController.navigate(DetailsDestination(relatedMovieId))
            }
        }
    }

}