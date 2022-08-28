package com.udacity.shoestore.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding:FragmentInstructionsBinding=DataBindingUtil.inflate(inflater,
           R.layout.fragment_instructions,container,false)
        binding.bShoeList.setOnClickListener { view:View->
            view.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
        }
        return binding.root
    }


}