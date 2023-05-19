package com.rgonzalez.cattracker.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.rgonzalez.cattracker.databinding.FragmentCatBinding


class CatFragment : Fragment() {

    private lateinit var binding: FragmentCatBinding
    private val catViewModel: CatViewModel by activityViewModels {
        CatViewModel.Factory
    }

    // TODO No sobreescribir metodos que no modifican el comportamiento por defecto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = catViewModel
    }


}