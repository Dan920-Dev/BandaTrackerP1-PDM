package com.jder00138218.bandastracker.repositories

import com.jder00138218.bandastracker.data.models.BandModel


/* Repository of bands */
class BandRepository(private var bands : MutableList<BandModel>) {

    fun getBands()  = bands // list of bands

    fun addBand(band: BandModel) = bands.add(band) // insert band in the list

}