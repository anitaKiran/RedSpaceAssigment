package com.redspace.rickandmortytest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.redspace.rickandmortytest.ui.adapter.LocationAdapter
import androidx.lifecycle.Observer
import com.redspace.rickandmortytest.data.viewmodel.SharedViewModel
import com.redspace.rickandmortytest.databinding.FragmentLocationBinding
import com.redspace.rickandmortytest.ui.adapter.AllEpisodeAdapter
import com.redspace.rickandmortytest.util.Status
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Anita Kiran on 26,June,2021
 */
@AndroidEntryPoint
class LocationFragment : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    lateinit var adapter : LocationAdapter
    lateinit var binding: FragmentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getLocations()
        viewModel.locationData.observe(requireActivity(), Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressbar.visibility = View.GONE
                    binding.locationRecyclerview.visibility = View.VISIBLE
                    adapter = LocationAdapter(requireActivity(), it.data!!.results)
                    binding.locationRecyclerview.adapter = adapter
                }
                Status.LOADING -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}