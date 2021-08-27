package com.ex2.ktmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.ex2.ktmovies.databinding.ActivityMainBinding
import com.ex2.ktmovies.presentation.home.HomeFragment
import com.ex2.ktmovies.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.container)
        }
    }
}