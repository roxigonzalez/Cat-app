package com.rgonzalez.cattracker.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rgonzalez.cattracker.R
import com.rgonzalez.cattracker.data.cats
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.ui.list.recyclerview.CatRecyclerViewAdapter
import com.rgonzalez.cattracker.databinding.FragmentCatListBinding

class CatListFragment : Fragment() {

    // 2 After create the view model, initialize it (and of course created the model and the repository)
    private val catsViewModel: CatsViewModel by activityViewModels {
        CatsViewModel.Factory
    }
    private lateinit var binding: FragmentCatListBinding
    private lateinit var recyclerViewAdapter: CatRecyclerViewAdapter
    // create the binding var


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
    }

    private fun showSelectedIem(cat: CatModel) {
        catsViewModel.setCatModel(cat)
        findNavController().navigate(R.id.action_catListFragment2_to_catFragment)
    }


    private fun displayCats() {
        recyclerViewAdapter.setData(catsViewModel.getCats())
        recyclerViewAdapter.notifyDataSetChanged()
    }
    private fun setRecyclerView(view: View) {
        binding.recyclerViewCat.layoutManager = LinearLayoutManager(view.context)
        recyclerViewAdapter = CatRecyclerViewAdapter{ selectedCat ->
            showSelectedIem(selectedCat)
        }
        binding.recyclerViewCat.adapter = recyclerViewAdapter
        displayCats()
    }
}