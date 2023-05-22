package com.jder00138218.bandastracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jder00138218.bandastracker.databinding.FragmentNewBandBinding
import com.jder00138218.bandastracker.ui.viewmodel.BandViewModel


class NewBandFragment : Fragment() {
    private lateinit var binding : FragmentNewBandBinding

    private lateinit var  buttonAdd2 : FloatingActionButton

    private val bandViewModel: BandViewModel by activityViewModels {
        BandViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBandBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAdd2 = view.findViewById(R.id.addButton)



            observeStatus()
            setViewModel()


    }

    private  fun observeStatus(){
        bandViewModel.status.observe(viewLifecycleOwner){ status ->
            when{
                status.equals(BandViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    bandViewModel.clearStatus()
                }
                status.equals(BandViewModel.MOVIE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", bandViewModel.getBands().toString())
                    bandViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


    private fun setViewModel(){
        binding.viewmodel = bandViewModel
    }
}