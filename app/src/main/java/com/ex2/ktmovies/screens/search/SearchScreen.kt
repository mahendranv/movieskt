package com.ex2.ktmovies.screens.search

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ex2.ktmovies.viewmodels.SearchViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val pageState = viewModel.pageState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.search("")
    }

    when (val state = pageState.value) {
        is SearchViewModel.PageState.Error -> {
            Text(text = state.message)
        }

        SearchViewModel.PageState.Initial -> {
            LinearProgressIndicator()
        }

        is SearchViewModel.PageState.Loaded -> {
            SearchListUi(list = state.list)
        }

        SearchViewModel.PageState.Loading -> {
            LinearProgressIndicator()
        }
    }
}