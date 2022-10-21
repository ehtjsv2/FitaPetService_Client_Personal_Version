package com.example.fitapet.ui.animalReg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnimalRegViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is AnimalReg Fragment"
    }
    val text: LiveData<String> = _text
}