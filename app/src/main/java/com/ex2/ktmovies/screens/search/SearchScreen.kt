package com.ex2.ktmovies.screens.search

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ex2.ktmovies.nav.DetailsDestination
import com.ex2.ktmovies.ui.atoms.FullScreenText
import com.ex2.ktmovies.ui.atoms.LoadingProgress
import com.ex2.ktmovies.viewmodels.SearchViewModel
import kotlinx.coroutines.android.awaitFrame

@Composable
fun SearchScreen(
    navController: NavController, modifier: Modifier = Modifier, viewModel: SearchViewModel = hiltViewModel()
) {
    val pageState = viewModel.pageState.collectAsState()
    val focusRequester = remember {
        FocusRequester()
    }
    val keyboard = LocalSoftwareKeyboardController.current
    var term by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = focusRequester) {
        awaitFrame()
        focusRequester.requestFocus()
    }

    Scaffold(modifier = modifier.windowInsetsPadding(WindowInsets.systemBars), topBar = {
        SearchBar(hint = "Movie", onTextChange = {
            term = it
        }, onSearchClicked = {
            viewModel.search(term)
            keyboard?.hide()
        }, modifier = Modifier.focusRequester(focusRequester)
        )
    }) { insets ->
        when (val state = pageState.value) {
            is SearchViewModel.PageState.Error -> {
                FullScreenText(text = state.message)
            }

            SearchViewModel.PageState.Initial -> {
                SearchEducationHintUi()
            }

            SearchViewModel.PageState.Loading -> {
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