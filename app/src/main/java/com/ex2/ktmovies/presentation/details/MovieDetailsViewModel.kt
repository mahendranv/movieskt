package com.ex2.ktmovies.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.usecase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
) : ViewModel() {

    private val _pageState: MutableStateFlow<PageState> =
        MutableStateFlow(PageState.Initial(heroImage = ""))
    val pageState: StateFlow<PageState> = _pageState
    // TODO: Hero image for fragment transition

    fun fetchMovieDetails(movieId: String) {
        getMovieDetailsUseCase.invoke(
            params = movieId,
            scope = viewModelScope,
            onResult = {
                it.fold({
                    // TODO: Handle failure
                }, {
                    _pageState.value = PageState.Loaded(it)
                })
            }
        )
    }

    sealed class PageState {

        data class Initial(val heroImage: String) : PageState()

        data class Loaded(val details: MovieDetails) : PageState()

        data class Error(val error: String) : PageState()
    }
}