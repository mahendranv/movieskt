package com.ex2.ktmovies.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ex2.ktmovies.R
import com.ex2.ktmovies.nav.DetailsDestination
import com.ex2.ktmovies.nav.SearchDestination
import com.ex2.ktmovies.ui.atoms.FullScreenText
import com.ex2.ktmovies.ui.atoms.LoadingProgress
import com.ex2.ktmovies.viewmodels.MovieListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, navController: NavController, viewModel: MovieListViewModel = hiltViewModel()
) {
    val pageState = viewModel.pageState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchList()
    }

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            scrollBehavior = scrollBehavior,
            actions = {
                IconButton({
                    navController.navigate(SearchDestination)
                }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_search_white_24dp), contentDescription = "")
                }
            }
        )
    }, floatingActionButton = {
        ExtendedFloatingActionButton(
            onClick = {
                navController.navigate(SearchDestination)
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_white_24dp),
                contentDescription = stringResource(id = R.string.search)
            )
            Text(
                text = stringResource(id = R.string.search),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }) { padding ->
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
