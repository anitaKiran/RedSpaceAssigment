package com.redspace.rickandmortytest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.redspace.rickandmortytest.data.model.Episode
import com.redspace.rickandmortytest.databinding.ItemEpisodeBinding

/**
 * Created by Anita Kiran on 28,June,2021
 */
class EpisodeAdapter(var context: Context, var items: List<Episode> = arrayListOf()) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        var binding = ItemEpisodeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(items.get(position), position)
    }

    override fun getItemCount() = items.size

    inner class EpisodeViewHolder(val itemBinding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(episode: Episode, position: Int) {
            itemBinding.tvEpisodeName.text = episode.name
            itemBinding.tvEpisodeNum.text = episode.episode
            itemBinding.tvEpisodeDate.text = episode.air_date
        }
    }
}