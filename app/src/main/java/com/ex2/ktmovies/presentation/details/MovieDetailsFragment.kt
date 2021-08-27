package com.ex2.ktmovies.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.ex2.ktmovies.R
import com.ex2.ktmovies.common.extensions.loadImage
import com.ex2.ktmovies.databinding.FragmentMovieDetailsBinding
import com.ex2.ktmovies.domain.model.MovieDetails
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    private val args: MovieDetailsFragmentArgs by navArgs()

    private val viewModel by viewModels<MovieDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMovieDetails(args.movieId)

        observeToFlow()
    }

    private fun observeToFlow() = lifecycleScope.launchWhenStarted {
        viewModel.pageState.collect {
            when (it) {
                is MovieDetailsViewModel.PageState.Error -> Snackbar.make(
                    binding.root,
                    it.error,
                    Snackbar.LENGTH_LONG
                ).show()
                is MovieDetailsViewModel.PageState.Initial -> Unit
                is MovieDetailsViewModel.PageState.Loaded -> {
                    setMovieDetails(it.details)
                }
            }
        }
    }

    private fun setMovieDetails(details: MovieDetails) {
        binding.coverImage.loadImage(
            url = details.covers.firstOrNull(),
            fallback = R.drawable.ic_launcher_background
        )
    }
}