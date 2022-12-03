package com.ex2.ktmovies.presentation.profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.request.ImageRequest
import com.ex2.ktmovies.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Profile/About fragment
 */
@AndroidEntryPoint
class ProfileFragment : Fragment() {

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageLoader.enqueue(
            ImageRequest.Builder(requireContext())
                .data(Uri.parse("file:///android_asset/img/tmdb.svg"))
                .target(binding.tmdbIcon)
                .build()
        )
    }
}