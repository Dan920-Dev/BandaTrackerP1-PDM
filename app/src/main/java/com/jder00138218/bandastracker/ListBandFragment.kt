package com.jder00138218.bandastracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jder00138218.bandastracker.data.models.BandModel
import com.jder00138218.bandastracker.databinding.FragmentListBandBinding
import com.jder00138218.bandastracker.ui.list.recyclerview.BandRecyclerViewAdapter
import com.jder00138218.bandastracker.ui.viewmodel.BandViewModel

class ListBandFragment : Fragment() {

    private lateinit var  buttonAdd : FloatingActionButton


    private lateinit var  binding: FragmentListBandBinding
    private lateinit var  adapter: BandRecyclerViewAdapter

    private val movieViewModel: BandViewModel by activityViewModels {
        BandViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBandBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView(view)
        buttonAdd = view.findViewById(R.id.add_band)

        buttonAdd.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_listBandFragment_to_newBandFragment)
        }

    }

    private fun showSelectedItem(band: BandModel){
        movieViewModel.setSelectBand(band)
        findNavController().navigate(R.id.action_listBandFragment_to_bandInfoFragment)
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getBands())
        adapter.notifyDataSetChanged()
    }

    private fun setRecycleView(view: View){
        binding.widgetRecycleView.layoutManager = LinearLayoutManager(view.context)
        adapter = BandRecyclerViewAdapter { selecttedBand ->
            showSelectedItem(selecttedBand)
        }

        binding.widgetRecycleView.adapter = adapter
        displayMovies()
    }

}