package com.rgonzalez.cattracker.ui.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.cattracker.R
import com.rgonzalez.cattracker.databinding.FragmentFormCatBinding
import com.rgonzalez.cattracker.ui.detail.CatViewModel

class FormCatFragment : Fragment() {

    private val catViewModel: FormCatViewModel by activityViewModels {
        CatViewModel.Factory
    }

    private lateinit var binding: FragmentFormCatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setViewModel() {
        binding.viewmodel = catViewModel
    }



}