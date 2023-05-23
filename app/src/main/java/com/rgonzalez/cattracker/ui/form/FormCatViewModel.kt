package com.rgonzalez.cattracker.ui.form

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.cattracker.CatReviewerApplication
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.repositories.CatRepository
import com.rgonzalez.cattracker.ui.detail.CatViewModel

class FormCatViewModel(private val repository: CatRepository) : ViewModel() {

    // declaring variables
    var name = MutableLiveData("")
    var color = MutableLiveData("")
    var age = MutableLiveData("")
    var status = MutableLiveData("")

    fun addCat(cat: CatModel) = repository.addCat(cat)

    fun createCat() {
        if(!validateCatData()) {
            status.value = CAT_ERROR
            return
        }
        val cat = CatModel(
            name.value!!,
            age.value!!.toInt(),
            color.value!!
        )
        addCat(cat)
        Log.d("TAG", "$cat Created")
        status.value = CAT_CREATED
        clearData()
    }

    fun clearData() {
        name.value = ""
        color.value = ""
        age.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }


    private fun validateCatData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            age.value.toString().isNullOrEmpty() -> return false
            color.value.isNullOrEmpty() -> return false
        }

        return true
    }
    companion object {
        val Factory = viewModelFactory {
           initializer {
               val app = this[APPLICATION_KEY] as CatReviewerApplication
               FormCatViewModel(app.catRepository)
           }
        }

        const val CAT_CREATED = "created"
        const val CAT_ERROR = "error"
        const val INACTIVE = ""
    }
}