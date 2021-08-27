package com.ex2.ktmovies.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ex2.ktmovies.databinding.FragmentMovieDetailsBinding
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    private val args: MovieDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: MovieDetailsViewModel.Factory
    private val viewModel by viewModels<MovieDetailsViewModel> {
        MovieDetailsViewModel.provideFactory(factory, args.movieId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}