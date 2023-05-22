package com.jder00138218.bandastracker

import android.app.Application
import com.jder00138218.bandastracker.data.bands
import com.jder00138218.bandastracker.repositories.BandRepository

class BandReviewerApplication: Application() {
    val bandsRepository : BandRepository by lazy {
        BandRepository(bands)
    }
}