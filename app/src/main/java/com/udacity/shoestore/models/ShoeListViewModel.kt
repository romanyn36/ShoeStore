package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
     private val _shoeData=MutableLiveData<MutableList<Shoe>>()
    val shoeData:LiveData<MutableList<Shoe>>
    get()=_shoeData
    private val _navi=MutableLiveData<Boolean>()
    val navi:LiveData<Boolean>
            get()=_navi
    init {
        _shoeData.value= mutableListOf()
        Timber.i("view model created")
        _navi.value=false
    }
fun addData(name: String, size: String, company: String, description: String)
{
Timber.i("added")

    _shoeData.value!!.add(Shoe(name,size.toDouble(),company,description))
    check()

}
    fun check()
    {
        _navi.value=true
        _navi.value=false
    }
}