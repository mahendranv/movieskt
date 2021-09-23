package com.ex2.ktmovies.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex2.ktmovies.common.extensions.hideKeyboard
import com.ex2.ktmovies.common.extensions.showKeyboard
import com.ex2.ktmovies.common.extensions.trimmedText
import com.ex2.ktmovies.databinding.FragmentSearchBinding
import com.ex2.ktmovies.platform.DisplayHelper
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

        binding.topBar.updatePadding(top = DisplayHelper.getStatusBarHeight(requireContext()))

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
        adapter.setOnItemClickListener {
            val direction =
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(it.id, it.imageUrl)
            findNavController().navigate(direction)
        }

        observeFlow()
    }

    private fun observeFlow() {
        lifecycleScope.launchWhenStarted {
            viewModel.pageState.collect {
                when (it) {
                    is SearchViewModel.PageState.Error -> {

                    }
                    is SearchViewModel.PageState.Loaded -> {
                        adapter.setItems(it.list)
                        adapter.notifyDataSetChanged()
                    }
                    SearchViewModel.PageState.Loading -> {

                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        binding.searchInput.hideKeyboard()
    }
}