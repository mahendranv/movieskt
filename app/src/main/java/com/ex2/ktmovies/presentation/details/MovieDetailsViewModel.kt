package com.ex2.ktmovies.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.usecase.GetMovieDetailsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieDetailsViewModel @AssistedInject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    @Assisted private val movieId: String,
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(movieId: String): MovieDetailsViewModel
    }

    private val _pageState: MutableStateFlow<PageState> =
        MutableStateFlow(PageState.Initial(heroImage = ""))
    val pageState: StateFlow<PageState> = _pageState
    // TODO: Hero image for fragment transition

    fun fetchMovieDetails() {
        getMovieDetailsUseCase.invoke(
            params = movieId,
            scope = viewModelScope,
            onResult = {
                it.fold({
                    // TODO: Handle failure
                }, {
                    _pageState.value = PageState.Loaded(it)
                    ""
                })
            }
        )
    }

    sealed class PageState {

        data class Initial(val heroImage: String) : PageState()

        data class Loaded(val details: MovieDetails) : PageState()

        data class Error(val error: String) : PageState()
    }

    companion object {

        fun provideFactory(
            factory: MovieDetailsViewModel.Factory,
            movieId: String
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {

                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return factory.create(movieId) as T
                }
            }
    }
}