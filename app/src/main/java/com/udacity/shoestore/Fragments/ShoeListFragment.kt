package com.udacity.shoestore.Fragments

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.RowBinding
import com.udacity.shoestore.models.ShoeListViewModel
import timber.log.Timber


class ShoeListFragment : Fragment() {
private lateinit var linearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentShoeListBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
     setHasOptionsMenu(true) //for log out menu
         linearLayout=binding.linear



//val viewModel=ViewModelProvider(this).get(ShoeListViewModel::class.java)
       val viewModel :ShoeListViewModel by activityViewModels()
        viewModel.shoeData.observe(this, Observer {
                shoeList->
            for (shoe in shoeList) {
                Timber.i("loop")
                //add rows
                 //first method to add layout
                    val rowBinding = RowBinding.inflate(layoutInflater)  /// to add rows to
                    rowBinding.shoe = shoe
                    binding.linear.addView(rowBinding.root)
                ////////second method to add view "text view for example"
//                    val  textView=TextView(context)
//                    val  params=LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                         LinearLayout.LayoutParams.WRAP_CONTENT)
//                         textView.layoutParams=params
//                         textView.text="added by addView()"
//                         linearLayout.addView(textView)

            }
        })

        binding.floatingActionButton.setOnClickListener({view:View->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        })


        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.log_out,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //step 3
        // when item selected
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())|| super.onOptionsItemSelected(item)

    }

}