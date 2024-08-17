package com.ex2.ktmovies.viewmodels

//class MovieDetailsViewModel @Inject constructor(
//    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
////    @Assisted private val movieId: String,
//) : ViewModel() {

//    @AssistedFactory
//    interface Factory {
//        fun create(movieId: String): MovieDetailsViewModel
//    }

// TODO: Assisted injection cannot co-exist with hilt viewmodels
// will require all the dependencies defined in @ViewModelScope
// Moving modules to Vanilla dagger style force us to write a lot of boilerplate.
//        fun provideFactory(
//            factory: MovieDetailsViewModel.Factory,
//            movieId: String
//        ): ViewModelProvider.Factory =
//            object : ViewModelProvider.Factory {
//
//                @Suppress("UNCHECKED_CAST")
//                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                    return factory.create(movieId) as T
//                }
//            }

//    @Inject
//    lateinit var factory: MovieDetailsViewModel.Factory
//    private val viewModel by viewModels<MovieDetailsViewModel> {
//        MovieDetailsViewModel.provideFactory(factory, args.movieId)
//    }