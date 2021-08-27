package com.ex2.ktmovies.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ex2.ktmovies.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

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

        // UI
        binding.homeRv.adapter = adapter
        adapter.setOnItemClickListener {

        }
        observeFlow()

        // API call
        viewModel.fetchNowPlaying()
    }

    private fun observeFlow() = lifecycleScope.launchWhenStarted {
        viewModel.movies.collect { movies ->
            adapter.setItems(movies)
            adapter.notifyDataSetChanged()
        }
    }
}
