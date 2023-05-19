package com.rgonzalez.cattracker.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.cattracker.CatReviewerApplication
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.repositories.CatRepository


// TODO: El ViewModel debe tener solo una resposabilidad por lo que deben tener un viewmodel por pantalla
class CatViewModel(private val repository: CatRepository):ViewModel() {


    // declaring variables
    var name = MutableLiveData("")
    var age = MutableLiveData("")
    var color = MutableLiveData("")

    fun setSelectedCat(cat: CatModel) {
        name.value = cat.name
        color.value = cat.color
        age.value = cat.age.toString()
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CatReviewerApplication
                CatViewModel(app.catRepository)
            }
        }
    }

}