package com.redspace.rickandmortytest.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController

import androidx.navigation.ui.setupWithNavController
import com.redspace.rickandmortytest.R
import com.redspace.rickandmortytest.data.viewmodel.SharedViewModel
import com.redspace.rickandmortytest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var navController: NavController
    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupNavController()
        setContent("Characters")
        binding.bottomNav.setupWithNavController(navController)
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.fragment_character -> {
                    setContent("Characters")
                    navController.navigate(R.id.characterFragment)
                    true
                }
                R.id.fragment_location -> {
                    setContent("Locations")
                    navController.navigate(R.id.locationFragment)
                    true
                }
                R.id.fragment_episode -> {
                    setContent("Episodes")
                    navController.navigate(R.id.episodeFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupNavController() {
        navController = findNavController(R.id.nav_host_fragment)
    }
   private fun setContent(content: String) {
        setTitle(content)
    }

}