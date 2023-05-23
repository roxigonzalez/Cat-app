package com.rgonzalez.cattracker.ui.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import com.rgonzalez.cattracker.R
import com.rgonzalez.cattracker.databinding.FragmentFormCatBinding

class FormCatFragment : Fragment() {

    private val formCatViewModel: FormCatViewModel by activityViewModels {
        FormCatViewModel.Factory
    }

    private lateinit var binding: FragmentFormCatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormCatBinding.inflate(inflater, container, false)
        val items = listOf("black", "white", "brown", "gray", "yellow")
        val adapter = ArrayAdapter(this.requireContext(), R.layout.item_list_colors, items )
        binding.ageList.setAdapter(adapter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun observeStatus() {
        formCatViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(FormCatViewModel.CAT_ERROR) -> {
                    Log.d("TAG", status)
                    formCatViewModel.clearStatus()
                }
                status.equals(FormCatViewModel.CAT_CREATED) -> {
                    Log.d("TAG", status)
                    formCatViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
    fun setViewModel() {
        binding.viewmodel = formCatViewModel
    }




}