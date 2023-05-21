package com.rgonzalez.cattracker.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.cattracker.CatReviewerApplication
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.repositories.CatRepository


// TODO: El ViewModel debe tener solo una resposabilidad por lo que deben tener un viewmodel por pantalla
class CatsViewModel(private val repository: CatRepository):ViewModel() {
    private val catModelLiveData = MutableLiveData<CatModel>()

    fun getCats() = repository.getCats()

    fun setCatModel(catModel: CatModel) {
        catModelLiveData.value = catModel
    }
    // TODO: Ask if is ok have the setSelectedCat here what other way can I use to pass the selected model
    fun getCatModel(): LiveData<CatModel> {
        return catModelLiveData
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CatReviewerApplication
                CatsViewModel(app.catRepository)
            }
        }
    }

}