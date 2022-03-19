package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //Dado mutável que vem vivo, passível de ser escutado.
    private var mTextWelcome = MutableLiveData<String>().apply { value = "Hello World!" }

    var textWelcome = mTextWelcome
    private var mRepository = PersonRepository()

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    /*init{
        mTextWelcome.value = "Hello World!"
    }*/

    fun login(name: String){
        val ret = mRepository.login(name)
        mLogin.value = ret
    }
}