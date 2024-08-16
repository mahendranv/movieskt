package com.ex2.ktmovies.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ex2.ktmovies.R
import com.ex2.ktmovies.databinding.FragmentHomeBinding
import com.ex2.ktmovies.domain.model.MovieListType
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureTabs()
    }

    private fun configureTabs() {
        binding.pages.adapter = HomeTabAdapter(childFragmentManager, lifecycle)
        // Title syncup
        TabLayoutMediator(binding.tabLayout, binding.pages) { tab, position ->
            val filter = homeTabs[position]
            val filterType = filter.listType
            tab.text = when (filterType) {
                MovieListType.NOW_PLAYING -> getString(com.ex2.ktmovies.R.string.type_now_playing)
                MovieListType.TRENDING -> getString(com.ex2.ktmovies.R.string.type_trending)
                MovieListType.TOP_RATED -> getString(com.ex2.ktmovies.R.string.type_top_rated)
                null -> getString(com.ex2.ktmovies.R.string.type_top_rated)
            }
        }.attach()
    }
}