package com.yaros.officetime.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecognizeVM : ViewModel() {
    val startSearchFragment = MutableLiveData<Boolean>()
    val startFindFragment = MutableLiveData<Int>()
    val selectResultFragment= MutableLiveData<Int>()
    val finishActivity= MutableLiveData<Boolean>()
    val startCommentFragment= MutableLiveData<Boolean>()

    fun searchFragment() {
        startSearchFragment.value =true
    }

    fun findFragment(type: Int) {
        startFindFragment.value =type
    }

    fun result(type : Int){
        selectResultFragment.value = type
    }

    fun finish(){
        finishActivity.value = true
    }

    fun comment() {
        startCommentFragment.value =true
    }
}