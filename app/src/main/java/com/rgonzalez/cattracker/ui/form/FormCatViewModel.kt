package com.rgonzalez.cattracker.ui.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.cattracker.CatReviewerApplication
import com.rgonzalez.cattracker.ui.detail.CatViewModel

class FormCatViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    companion object {
        val Factory = viewModelFactory {
           initializer {
               val app = this[APPLICATION_KEY] as CatReviewerApplication
               CatViewModel(app.catRepository)
           }
        }
    }
}