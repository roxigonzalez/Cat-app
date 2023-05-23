package com.rgonzalez.cattracker.repositories

import android.util.Log
import com.rgonzalez.cattracker.data.model.CatModel

class CatRepository(private val cats:MutableList<CatModel>) {
    // here we're gonna get our data dummy
    fun getCats() = cats

    // here we're adding a new element of the mutable list :)
    fun addCat(cat: CatModel) {
        Log.d("TAG", "${cat} here")
        cats.add(0, cat)
        Log.d("TAG", "${cats} here cats")
    }
}