package com.ex2.ktmovies.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ex2.ktmovies.common.extensions.showIf
import com.ex2.ktmovies.databinding.FragmentMovieListBinding
import com.ex2.ktmovies.domain.model.MovieFilter
import com.ex2.ktmovies.platform.DisplayHelper
import com.ex2.ktmovies.platform.GridSpacingItemDecoration
import com.ex2.ktmovies.viewmodels.MovieListViewModel
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private val viewModel: MovieListViewModel by viewModels()

    private val adapter by lazy { MovieListAdapter() }

    private val filter by lazy { requireArguments().getParcelable(ARG_MOVIE_FILTER) as MovieFilter? }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (filter == null) {
            throw IllegalArgumentException("Filter not found")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        viewModel.updateFilter(filter!!)

        // UI
//        binding.toolBar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
//            topMargin = DisplayHelper.getStatusBarHeight(requireContext())
//        }
//        binding.toolBar.setOnMenuItemClickListener {
//            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
//            true
//        }
//        binding.sectionSpinner.adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            resources.getStringArray(R.array.arr_movie_sections)
//        )
//        binding.homeRv.updatePadding(
//            top = DisplayHelper.getStatusBarHeight(requireContext()) + DisplayHelper.getActionBarHeight(
//                requireContext()
//            )
//        )

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
                duration = resources.getInteger(com.ex2.ktmovies.R.integer.motion_duration_large).toLong()
            }
            enterTransition = MaterialElevationScale(true).apply {
                duration = resources.getInteger(com.ex2.ktmovies.R.integer.motion_duration_large).toLong()
            }
            val targetName = getString(com.ex2.ktmovies.R.string.transition_target_movie_details) + movie.id
            val extras = FragmentNavigatorExtras(itemView to targetName)
            val direction =
                MovieListFragmentDirections.actionMovieListFragmentToDetailsFragment(
                    movie.id,
                    movie.imageUrl
                )
            findNavController().navigate(direction, extras)
        }
        binding.progressCircular.apply {
            isIndeterminate = true
        }
        observeFlow()

        // API call
        viewModel.fetchList()
    }

    private fun observeFlow() = lifecycleScope.launchWhenStarted {
        viewModel.pageState
            .onEach { state ->
                binding.progressCircular.showIf(state == MovieListViewModel.PageState.Loading)
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

        private const val ARG_MOVIE_FILTER = "arg_movie_filter"

        fun newInstance(filter: MovieFilter) = MovieListFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_MOVIE_FILTER, filter)
            }
        }
    }
}
