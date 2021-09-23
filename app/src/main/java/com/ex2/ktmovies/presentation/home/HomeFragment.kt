package com.ex2.ktmovies.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ex2.ktmovies.R
import com.ex2.ktmovies.common.extensions.showIf
import com.ex2.ktmovies.databinding.FragmentHomeBinding
import com.ex2.ktmovies.platform.DisplayHelper
import com.ex2.ktmovies.platform.GridSpacingItemDecoration
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val adapter by lazy { HomeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        // UI
        binding.toolBar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = DisplayHelper.getStatusBarHeight(requireContext())
        }
        binding.toolBar.setOnMenuItemClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
            true
        }

        binding.homeRv.updatePadding(
            top = DisplayHelper.getStatusBarHeight(requireContext()) + DisplayHelper.getActionBarHeight(
                requireContext()
            )
        )
        binding.homeRv.layoutManager = GridLayoutManager(requireContext(), SPAN_COUNT)
        binding.homeRv.addItemDecoration(
            GridSpacingItemDecoration(
                spanCount = SPAN_COUNT,
                spacing = DisplayHelper.DP_16,
                includeEdge = true
            )
        )
        binding.homeRv.adapter = adapter
        adapter.setOnItemClickListener { itemView, movie ->
            exitTransition = MaterialElevationScale(false).apply {
                duration = resources.getInteger(R.integer.motion_duration_large).toLong()
            }
            enterTransition = MaterialElevationScale(true).apply {
                duration = resources.getInteger(R.integer.motion_duration_large).toLong()
            }
            val targetName = getString(R.string.transition_target_movie_details)
            val extras = FragmentNavigatorExtras(itemView to targetName)
            val direction =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movie.id, movie.imageUrl)
            findNavController().navigate(direction, extras)
        }
        binding.progressCircular.apply {
            isIndeterminate = true
        }
        observeFlow()

        // API call
        viewModel.fetchNowPlaying()
    }

    private fun observeFlow() = lifecycleScope.launchWhenStarted {
        viewModel.pageState
            .onEach { state ->
                binding.progressCircular.showIf(state == HomeViewModel.PageState.Loading)
            }
            .launchIn(lifecycleScope)

        viewModel.movies
            .onEach { movies ->
                adapter.setItems(movies)
                adapter.notifyDataSetChanged()
            }
            .launchIn(lifecycleScope)
    }

    companion object {
        const val SPAN_COUNT = 2
    }
}
