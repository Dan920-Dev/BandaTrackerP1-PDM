package com.jder00138218.bandastracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jder00138218.bandastracker.databinding.FragmentBandInfoBinding
import com.jder00138218.bandastracker.ui.viewmodel.BandViewModel

class BandInfoFragment : Fragment() {

    private lateinit var binding: FragmentBandInfoBinding

    private val bandViewModel: BandViewModel by activityViewModels {
        BandViewModel.Factory
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBandInfoBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }


    private fun setViewModel(){
        binding.viewmodel = bandViewModel
    }

}