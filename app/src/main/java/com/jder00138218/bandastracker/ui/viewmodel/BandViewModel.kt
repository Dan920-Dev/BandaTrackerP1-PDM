package com.jder00138218.bandastracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jder00138218.bandastracker.BandReviewerApplication
import com.jder00138218.bandastracker.data.models.BandModel
import com.jder00138218.bandastracker.repositories.BandRepository

class BandViewModel(val bandRepository: BandRepository): ViewModel() {

    var name = MutableLiveData("")
    var genre = MutableLiveData("")
    var musical = MutableLiveData("")
    var status = MutableLiveData("")



    fun getBands() = bandRepository.getBands()
    fun addBand(band:BandModel) = bandRepository.addBand(band)

    // Clear Data, Status, Validate Data

    fun createband(){

        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val band = BandModel(
            name.value!!,
            genre.value!!,
            musical.value!!
        )

        addBand(band)
        clearData()
        status.value = BAND_CREATED
    }


    private fun validateData(): Boolean {
        when{
           name.value.isNullOrEmpty() -> return false
            genre.value.isNullOrEmpty() -> return false
            musical.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun clearData() {
        name.value = ""
        genre.value = ""
        musical.value = ""
    }

    fun setSelectBand(band: BandModel){
        name.value = band.name
        genre.value = band.genre
        musical.value = band.musical
    }


    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BandReviewerApplication
                BandViewModel(app.bandsRepository)
            }
        }

        const val BAND_CREATED = "Band Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE =  "Inactive"
    }
}