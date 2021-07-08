package com.redspace.rickandmortytest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redspace.rickandmortytest.data.model.Results
import com.redspace.rickandmortytest.databinding.ItemLocationListBinding
import com.redspace.rickandmortytest.databinding.RecyclerviewItemBinding

/**
 * Created by Anita Kiran on 28,June,2021
 */
class LocationAdapter(var context: Context, var items: List<Results> = arrayListOf()) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        var binding = ItemLocationListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(items.get(position), position)
    }

    override fun getItemCount() = items.size

    inner class LocationViewHolder(val itemBinding: ItemLocationListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(results: Results, position: Int) {
            itemBinding.tvLocationName.text = results.name
            itemBinding.tvLocationType.text = results.type
            itemBinding.tvLocationDimension.text = results.dimension
        }
    }
}