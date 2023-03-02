package com.carfax.assignment.ui.main

import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.carfax.assignment.R
import com.carfax.assignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        setupToolbarProvider()
    }

    private fun initNavigation() {
        navHostFragment = (supportFragmentManager.findFragmentById(R.id.fragment_host)
                as NavHostFragment)
        navController = navHostFragment.findNavController()
    }

    private fun setupToolbarProvider() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.detailsFragment -> {
                    this.window?.statusBarColor = resources.getColor(R.color.grey_trans)
                    hideCustomUI()
                }
                else -> {
                    showCustomUI()
                    this.window?.statusBarColor = resources.getColor(R.color.blue_dark)

                }
            }
        }
    }

    private fun showCustomUI() {
        val decorView: View = window.decorView
        decorView.systemUiVisibility =
            (SYSTEM_UI_FLAG_LAYOUT_STABLE and View.SYSTEM_UI_FLAG_VISIBLE)
        this.supportActionBar?.show()
    }

    private fun hideCustomUI() {
        val decorView: View = window.decorView
        decorView.systemUiVisibility =
            (SYSTEM_UI_FLAG_LAYOUT_STABLE and View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        this.supportActionBar?.hide()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_host)
        navController.navigateUp()
        return true
    }
}
