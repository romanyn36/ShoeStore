package com.udacity.shoestore.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {
private lateinit var binding:FragmentShoeDetailBinding
private lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        // viewModel=ViewModelProvider(this).get(ShoeListViewModel::class.java)
        val viewModel :ShoeListViewModel by activityViewModels()  // to save list
        binding.shoeViewModel =viewModel
        binding.shoeData= Shoe("",0.0,"","")
        binding.setLifecycleOwner(this)

        viewModel.navi.observe(viewLifecycleOwner, Observer { check->
            if (check)
                //Navigation.findNavController(view!!).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment) //create new fragment
                // or navigateUp() tat go previous //not create new this best for performance
                Navigation.findNavController(view!!).navigateUp()

        })
        return binding.root
    }


}