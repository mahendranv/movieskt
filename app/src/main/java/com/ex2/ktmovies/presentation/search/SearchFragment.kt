package com.ex2.ktmovies.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.doOnPreDraw
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex2.ktmovies.R
import com.ex2.ktmovies.common.extensions.hideKeyboard
import com.ex2.ktmovies.common.extensions.showIf
import com.ex2.ktmovies.common.extensions.showKeyboard
import com.ex2.ktmovies.common.extensions.trimmedText
import com.ex2.ktmovies.databinding.FragmentSearchBinding
import com.ex2.ktmovies.platform.DisplayHelper
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by viewModels()

    private val adapter by lazy { MovieSearchResultAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

//        binding.topBar.updatePadding(top = DisplayHelper.getStatusBarHeight(requireContext()))

        if (adapter.itemCount == 0) {
            binding.searchInput.requestFocus()
            binding.searchInput.showKeyboard()
        }

        // Setup input field
        binding.searchInput.setOnEditorActionListener { textView, actionId, keyEvent ->
            // TODO: keyevent is null in samsung device. Check it in other OEMs to make sure
            // event fired only once
            val term = textView.trimmedText()
            if (actionId == EditorInfo.IME_ACTION_SEARCH && term.isNotEmpty()) {
                binding.searchInput.hideKeyboard()
                viewModel.search(term)
            }
            true
        }

        binding.searchRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.searchRv.adapter = adapter
        adapter.setOnItemClickListener { binding, item ->
            exitTransition = MaterialElevationScale(false).apply {
                duration = resources.getInteger(R.integer.motion_duration_large).toLong()
            }
            enterTransition = MaterialElevationScale(true).apply {
                duration = resources.getInteger(R.integer.motion_duration_large).toLong()
            }

            val targetName = getString(R.string.transition_target_movie_details)
            val extras = FragmentNavigatorExtras(binding.movieThumb to targetName)
            val direction =
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(item.id, item.imageUrl)
            findNavController().navigate(direction, extras)
        }
        binding.progressCircular.isIndeterminate = true
        observeFlow()
    }

    private fun observeFlow() {
        lifecycleScope.launchWhenStarted {
            viewModel.pageState.collect {
                binding.progressCircular.showIf(it == SearchViewModel.PageState.Loading)
                when (it) {
                    is SearchViewModel.PageState.Loaded -> {
                        adapter.setItems(it.list)
                        adapter.notifyDataSetChanged()
                    }
                    is SearchViewModel.PageState.Error,
                    SearchViewModel.PageState.Loading -> Unit
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        binding.searchInput.hideKeyboard()
    }
}