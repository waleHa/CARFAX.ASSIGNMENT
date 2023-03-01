package com.carfax.assignment.ui.main

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.carfax.assignment.R
import com.carfax.assignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initNavigation()
        setupToolbarProvider()

    }

//    private fun showCustomUI() {
//        val decorView: View = window.decorView
//        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  )
//    }
//
// private fun hideCustomUI() {
//        val decorView: View = window.decorView
//        decorView.systemUiVisibility = (View.STATUS_BAR_VISIBLE  and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION )
//    }

    private fun hideSystemUI() {

        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.root).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(
            window,
            binding.root
        ).show(WindowInsetsCompat.Type.systemBars())
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
                    hideSystemUI()
                    this.window?.statusBarColor = Color.GRAY
//                    this?.actionBar?.show()
//                    this?.supportActionBar?.show()

                }
                else -> {
                    this.window?.statusBarColor = resources.getColor(R.color.blue_dark)
                    showSystemUI()
//                    this?.actionBar?.show()
                }
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_host)
        navController.navigateUp()
        return true
    }
}