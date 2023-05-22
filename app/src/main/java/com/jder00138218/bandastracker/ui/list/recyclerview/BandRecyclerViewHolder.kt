package com.jder00138218.bandastracker.ui.list.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.jder00138218.bandastracker.data.bands
import com.jder00138218.bandastracker.data.genre
import com.jder00138218.bandastracker.data.models.BandModel
import com.jder00138218.bandastracker.databinding.BandItemBinding

class BandRecyclerViewHolder(private val binding: BandItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(band: BandModel, clickListener: (BandModel) -> Unit){

        binding.bandGenreTextView.text = band.genre
        binding.bandMusicalTextView.text = band.musical
        binding.bandNameTextView.text = band.name

        binding.bandItemCardView.setOnClickListener{
            clickListener(band)
        }
    }


}