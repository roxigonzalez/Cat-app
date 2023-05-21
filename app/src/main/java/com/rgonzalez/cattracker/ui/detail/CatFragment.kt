package com.rgonzalez.cattracker.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.rgonzalez.cattracker.databinding.FragmentCatBinding
import com.rgonzalez.cattracker.ui.list.CatsViewModel


class CatFragment : Fragment() {

    private lateinit var binding: FragmentCatBinding
    private val catViewModel: CatViewModel by activityViewModels {
        CatViewModel.Factory
    }
    private val catsViewModel: CatsViewModel by activityViewModels {
        CatsViewModel.Factory
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catModelFromList = catsViewModel.getCatModel()
        catModelFromList.value?.let { catViewModel.setCatModel(it) }
        binding.viewmodel = catViewModel
        Log.d("TAG",  "${catModelFromList.value.toString()}")
    }


}