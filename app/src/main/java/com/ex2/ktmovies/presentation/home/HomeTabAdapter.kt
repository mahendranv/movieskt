package com.ex2.ktmovies.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ex2.ktmovies.domain.model.MovieFilter
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.presentation.list.MovieListFragment

val homeTabs = listOf(
    MovieFilter(listType = MovieListType.NOW_PLAYING),
    MovieFilter(listType = MovieListType.TRENDING),
    MovieFilter(listType = MovieListType.TOP_RATED),
)

class HomeTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = homeTabs.size

    override fun createFragment(position: Int): Fragment {
        return MovieListFragment.newInstance(homeTabs[position])
    }
}