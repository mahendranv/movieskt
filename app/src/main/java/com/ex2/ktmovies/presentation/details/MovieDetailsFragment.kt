package com.ex2.ktmovies.presentation.details

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.palette.graphics.Palette
import com.ex2.ktmovies.R
import com.ex2.ktmovies.common.extensions.loadImage
import com.ex2.ktmovies.common.extensions.showIf
import com.ex2.ktmovies.common.extensions.themeColor
import com.ex2.ktmovies.databinding.FragmentMovieDetailsBinding
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.platform.pickPalette
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    private val args: MovieDetailsFragmentArgs by navArgs()

    private val viewModel by viewModels<MovieDetailsViewModel>()

    private val adapter by lazy { RelatedMoviesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Transition
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = com.ex2.ktmovies.R.id.container
            duration = resources.getInteger(com.ex2.ktmovies.R.integer.motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(com.google.android.material.R.attr.colorSurface))
        }
    }

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

        // Transition support
        binding.root.transitionName = getString(com.ex2.ktmovies.R.string.transition_target_movie_details) + args.movieId
        binding.topPanel.coverImage.loadImage(args.posterUrl)

        binding.relatedRv.adapter = adapter
        adapter.setOnItemClickListener {
            findNavController().navigate(
                MovieDetailsFragmentDirections.actionDetailsFragmentSelf(it.id, it.imageUrl)
            )
        }
        binding.topPanel.backKey.setOnClickListener {
            findNavController().popBackStack()
        }
        observeToFlow()
    }

    private fun observeToFlow() = lifecycleScope.launchWhenStarted {
        viewModel.pageState.collect {

            binding.relatedMoviesTitle.showIf(it is MovieDetailsViewModel.PageState.Loaded)

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

    private fun setMovieDetails(details: MovieDetails) = with(binding) {
//        topPanel.coverImage.loadImage(
//            url = details.covers.firstOrNull(),
//            fallback = R.drawable.ic_launcher_background
//        )
//        repaintContent(details.covers.firstOrNull())
        topPanel.titleLabel.text = details.title
        summaryLabel.text = details.summary
        adapter.setItems(details.related)
        topPanel.metaLabel.text = details.prepareMeta()
    }

    /**
     * Given the url - invokes pattern generator and ensures palette drawn in UI thread
     */
    private fun repaintContent(url: String?) {
        if (url.isNullOrBlank()) return

        lifecycleScope.launch {
            val palette = pickPalette(requireContext(), url)
            if (palette != null) {
                updateColor(palette)
            }
        }
    }

    private fun updateColor(palette: Palette) = with(Dispatchers.Main) {
        val color = palette.getLightVibrantColor(Color.WHITE)
        ImageViewCompat.setImageTintList(
            binding.topPanel.backKey,
            ColorStateList.valueOf(color)
        )
    }
}