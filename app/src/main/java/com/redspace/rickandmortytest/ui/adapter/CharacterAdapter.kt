package com.redspace.rickandmortytest.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redspace.rickandmortytest.data.model.Results
import com.redspace.rickandmortytest.databinding.RecyclerviewItemBinding
import com.redspace.rickandmortytest.ui.activities.CharacterDetailActivity

/**
 * Created by Anita Kiran on 28,June,2021
 */
class CharacterAdapter(var context: Context, var items: List<Results> = arrayListOf()) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        var binding = RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items.get(position), position)
    }

    override fun getItemCount() = items.size

    inner class CharacterViewHolder(val itemBinding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(results: Results, position: Int) {
            itemBinding.title.text = results.name
            Glide.with(itemView)
                .load(results.image)
                .into(itemBinding.gridImageView)

            itemBinding.gridImageView.setOnClickListener {
                val intent = Intent(context, CharacterDetailActivity::class.java)
                intent.putExtra("CHARACTER_DETAIL", results)
                context.startActivity(intent)
            }
        }
    }
}