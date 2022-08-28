package com.udacity.shoestore

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        Timber.i("Main")

        ////////////////// navigattion
        val navController=findNavController(R.id.myNavHostFragment)
        setSupportActionBar(binding.toolbar)  //set your custom bar
        NavigationUI.setupActionBarWithNavController(this,navController)
        appBarConfiguration = AppBarConfiguration(navController.graph) // use this wit @1
/////////////////
    }


    override fun onSupportNavigateUp(): Boolean { //3
        val navControl =this.findNavController(R.id.myNavHostFragment)  // to use your navigation in xml your ar made
        //return  navControl.navigateUp()  //back button in nav bar
        return NavigationUI.navigateUp(navControl,appBarConfiguration)//replace button with menu    /////// @1
           //@2 /// make menue in left and connect drawer with bar but exist action
    }
}
