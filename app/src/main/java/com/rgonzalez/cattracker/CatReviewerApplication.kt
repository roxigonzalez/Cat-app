package com.rgonzalez.cattracker

import android.app.Application
import com.rgonzalez.cattracker.data.cats
import com.rgonzalez.cattracker.repositories.CatRepository

class CatReviewerApplication:Application() {
    val catRepository: CatRepository by lazy {
        CatRepository(cats)
    }
}