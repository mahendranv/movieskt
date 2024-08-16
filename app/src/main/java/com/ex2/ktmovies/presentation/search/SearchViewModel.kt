package com.ex2.ktmovies.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.domain.usecase.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _pageState = MutableStateFlow<PageState>(PageState.Initial)
    val pageState: StateFlow<PageState> = _pageState

    fun search(term: String) {
        _pageState.value = PageState.Loading
        viewModelScope.launch {
            searchMoviesUseCase.run(term)
                .fold({
                    _pageState.value = PageState.Error(it.toString())
                }, {
                    _pageState.value = PageState.Loaded(it)
                })
        }
    }

    sealed class PageState {
        object Loading : PageState()
        object Initial : PageState()
        data class Loaded(val list: List<MovieResult>) : PageState()
        data class Error(val message: String) : PageState()
    }
}