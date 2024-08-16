package com.ex2.ktmovies

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ex2.ktmovies.common.extensions.showIf
import com.ex2.ktmovies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var navControllerRef: WeakReference<NavController?> = WeakReference(null)
    private var navController: NavController?
        get() = navControllerRef.get()
        set(value) {
            navControllerRef = WeakReference(value)
        }

    private val destinationListener = { _: NavController, destination: NavDestination, _: Bundle? ->
        val mainRoute = destination.id in arrayOf(
            com.ex2.ktmovies.R.id.homeFragment,
            com.ex2.ktmovies.R.id.profileFragment,
            com.ex2.ktmovies.R.id.searchFragment
        )
        binding.mainNavBar.showIf(mainRoute)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setupBottomNavigation()
    }

    /**
     * Bottom navigation wiring
     */
    private fun setupBottomNavigation() {
        // Few nuances about setting up the bottom navigation bar with nav-host
        // 1. FragmentContainerView can't return nav controller - even though the container is
        // set with NavHostFragment. Workaround is to use find fragment by id and cast to NavHostFragment
        // 2. For setupWithNavController to work, both the menu xml and navigation xml should
        // carry the same id-s. i.e homeFragment vs homeFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(com.ex2.ktmovies.R.id.container) as NavHostFragment
        navController = navHostFragment.navController
        binding.mainNavBar.setupWithNavController(navController!!)

        // Navigation listener and bottom bar visibility
        navController?.addOnDestinationChangedListener(destinationListener)
    }

    override fun onDestroy() {
        navController?.removeOnDestinationChangedListener(destinationListener)
        super.onDestroy()
    }
}