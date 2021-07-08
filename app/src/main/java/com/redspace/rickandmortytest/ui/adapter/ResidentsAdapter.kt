package com.redspace.rickandmortytest.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redspace.rickandmortytest.data.model.Results
import com.redspace.rickandmortytest.databinding.ItemResidentsListBinding
import com.redspace.rickandmortytest.databinding.RecyclerviewItemBinding

/**
 * Created by Anita Kiran on 28,June,2021
 */

class ResidentsAdapter(var context: Context, var items: List<String> = arrayListOf()) :
    RecyclerView.Adapter<ResidentsAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var binding = ItemResidentsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(items.get(position), position)
    }

    override fun getItemCount() = items.size

    inner class DataViewHolder(val itemBinding: ItemResidentsListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(residents: String, position: Int) {
            Log.e("reside", residents)
            Glide.with(context)
                .load("https://rickandmortyapi.com/api/character/455")
                .into(itemBinding.residentImg)
        }
    }

}
