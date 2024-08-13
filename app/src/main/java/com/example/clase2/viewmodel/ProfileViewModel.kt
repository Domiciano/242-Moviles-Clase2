package com.example.clase2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel() : ViewModel() {

    var name:MutableLiveData<String> = MutableLiveData("NO_NAME")
    var email:MutableLiveData<String> = MutableLiveData("NO_EMAIL")
    var description:MutableLiveData<String> = MutableLiveData("NO_DESC")

    fun changeName(value:String){
        //Cuando cambio el value notifico al observador (View)
        name.value = value
    }

}