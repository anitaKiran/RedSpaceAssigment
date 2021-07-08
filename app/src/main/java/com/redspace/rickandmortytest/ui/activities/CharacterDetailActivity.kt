package com.redspace.rickandmortytest.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.redspace.rickandmortytest.data.model.Results
import com.redspace.rickandmortytest.data.viewmodel.DetailsViewModel
import com.redspace.rickandmortytest.databinding.ActivityCharacterDetailsBinding
import com.redspace.rickandmortytest.databinding.ActivityMainBinding
import com.redspace.rickandmortytest.ui.adapter.CharacterAdapter
import com.redspace.rickandmortytest.ui.adapter.EpisodeAdapter
import com.redspace.rickandmortytest.ui.adapter.LocationAdapter
import com.redspace.rickandmortytest.util.Status
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Anita Kiran on 30,June,2021
 */
@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityCharacterDetailsBinding
    var character: Results? = null
    lateinit var episodes: List<String>
    lateinit var adapter: EpisodeAdapter
    private val viewModel: DetailsViewModel by viewModels()
    var name : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDetails()
        setToolbar()

    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = name
        }
    }

    private fun setDetails() {
        character = intent.getParcelableExtra("CHARACTER_DETAIL") as? Results
        episodes = character!!.episode
        //Log.e("DetailActivity", character.toString())

        Glide.with(this)
            .load(character?.image)
            .into(binding.characterImage)

        name = character?.name
        binding.tvNameStatus.text =  "Status: " + character?.status
        binding.tvGender.text =" " + character?.species + " | " + character?.gender
        binding.tvLocation.text = character?.location?.name

        setEpisodes()
    }

    private fun setEpisodes() {
        val sb = StringBuilder()
        for (item in episodes) {
            val splitArray: List<String> = item.split("/")
            val episodeNum = Integer.parseInt(splitArray.get(splitArray.size - 1))
            sb.append(episodeNum).append(",")
        }
        viewModel.getEpisodesById(sb.toString())
        viewModel.episodeData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressbar.visibility = View.GONE
                    binding.rvCharacterEpisodes.visibility = View.VISIBLE
                    adapter = EpisodeAdapter(this, it.data!!)
                    binding.rvCharacterEpisodes.adapter = adapter
                }
                Status.LOADING -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

