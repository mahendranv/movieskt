package com.ex2.ktmovies.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.ktmovies.domain.model.MovieFilter
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.usecase.GetLiteMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val liteMoviesUseCase: GetLiteMoviesUseCase
) : ViewModel() {

    private val _movies: MutableStateFlow<List<MovieLite>> = MutableStateFlow(emptyList())
    val movies: StateFlow<List<MovieLite>> = _movies
    private val _pageState: MutableStateFlow<PageState> = MutableStateFlow(PageState.Loading)
    val pageState: StateFlow<PageState> = _pageState

    /**
     * Filter for movie listing
     */
    private var filter: MovieFilter = MovieFilter()

    /**
     * Flag to mark list reload
     */
    private var reloadItems = true

    fun updateFilter(filter: MovieFilter) {
        reloadItems = (this.filter != filter)
        this.filter = filter
    }

    private fun shouldLoadContent() =
        pageState.value != PageState.Loading && (reloadItems || movies.value.isEmpty())

    fun fetchList() {
        if (shouldLoadContent()) {
            return
        }

        _pageState.value = PageState.Loading
        liteMoviesUseCase(
            params = GetLiteMoviesUseCase.Params(
                listType = filter.listType ?: MovieListType.NOW_PLAYING
            ),
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