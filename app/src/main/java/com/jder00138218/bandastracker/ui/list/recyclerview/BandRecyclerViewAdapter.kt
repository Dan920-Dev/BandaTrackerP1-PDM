package com.jder00138218.bandastracker.ui.list.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jder00138218.bandastracker.data.models.BandModel
import com.jder00138218.bandastracker.databinding.BandItemBinding

class BandRecyclerViewAdapter(
private val clcikListener: (BandModel) -> Unit
) : RecyclerView.Adapter<BandRecyclerViewHolder>() {

    private val bands = ArrayList<BandModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandRecyclerViewHolder {
        val binding = BandItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return BandRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BandRecyclerViewHolder, position: Int) {
        val band = bands[position]
         holder.bind(band, clcikListener)
    }

    override fun getItemCount(): Int {
        return bands.size
    }

    fun setData(bandList: List<BandModel>){
        bands.clear()
        bands.addAll(bandList)
    }

}