package com.example.fitapet.ui.animalReg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kakao.sdk.user.model.BirthdayType

class AnimalRegViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is AnimalReg Fragment"
    }
    var dogOrCat :Int = -1 // 0->dog 1->cat
    var boyOrGrl :Int = -1 // 0->boy 1->girl
    var neu :Int = -1 // 0-> 중성화x , 1->중성화  o
    var chip:Int = -1 // 0-> 외장칩 1->내장칩
    var weight:Int =-1 //0 ->소 1->중 2->대
    var weight2:Int = -1 // 0-> 소/중 1-> 대
    var name: String? =null
    var breed: String? =null
    val text: LiveData<String> = _text
}
