package com.example.livedataexample.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val usd_to_eu_rate = 100f

    private var product = ""

   // private var result: Float = 0f
    private  var result : MutableLiveData<Float> = MutableLiveData()


    fun setAmount(value1: String, value2 : String) {

        this.product = (value1.toFloat() * value2.toFloat()).toString()

        //result = value.toFloat() * usd_to_eu_rate
    result.setValue(value1.toFloat() * value2.toFloat())
    }



    //fun getResult(): Float? {

    fun getResult():MutableLiveData<Float>{
        return result

    }
}