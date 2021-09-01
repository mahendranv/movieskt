package com.ex2.ktmovies.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.usecase.GetLiteMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val liteMoviesUseCase: GetLiteMoviesUseCase
) : ViewModel() {

    private val _movies: MutableStateFlow<List<MovieLite>> = MutableStateFlow(emptyList())
    val movies: StateFlow<List<MovieLite>> = _movies
    private val _pageState: MutableStateFlow<PageState> = MutableStateFlow(PageState.Loading)
    val pageState: StateFlow<PageState> = _pageState

    fun fetchNowPlaying() {
        if (movies.value.isNotEmpty()) {
            return
        }

        _pageState.value = PageState.Loading
        liteMoviesUseCase(
            params = GetLiteMoviesUseCase.Params(listType = MovieListType.NOW_PLAYING),
            viewModelScope,
            onResult = { response ->
                response.fold(
                    {
                        _pageState.value = PageState.Error
                    },
                    {
                        _movies.value = it
                        _pageState.value = PageState.Loaded
                    }
                )
            }
        )
    }

    sealed class PageState {
        object Loading : PageState()
        object Loaded : PageState()
        object Error : PageState()
    }
}