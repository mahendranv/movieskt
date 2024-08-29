package com.ex2.ktmovies.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ex2.ktmovies.nav.DetailsDestination
import com.ex2.ktmovies.ui.atoms.FullScreenText
import com.ex2.ktmovies.ui.atoms.LoadingProgress
import com.ex2.ktmovies.viewmodels.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavController, modifier: Modifier = Modifier, viewModel: SearchViewModel = hiltViewModel()
) {
    val pageState = viewModel.pageState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.search("")
    }

    Scaffold { insets ->
        when (val state = pageState.value) {
            is SearchViewModel.PageState.Error -> {
                FullScreenText(text = state.message)
            }

            SearchViewModel.PageState.Initial, SearchViewModel.PageState.Loading -> {
                LoadingProgress()
            }

            is SearchViewModel.PageState.Loaded -> {
                SearchListUi(list = state.list, modifier = Modifier.padding(insets)) { id ->
                    navController.navigate(DetailsDestination(id))
                }
            }
        }
    }

}