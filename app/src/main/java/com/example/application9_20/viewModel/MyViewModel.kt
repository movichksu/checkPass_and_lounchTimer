package com.example.application9_20.viewModel

import android.content.Context
import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.application9_20.model.PinManager

class MyViewModel(
) : ViewModel(){

    val viewText = MutableLiveData<String>()
    fun getTimer(){
        val timer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                viewText.postValue(" ${millisUntilFinished / 1000}")
            }
            override fun onFinish() {
                viewText.postValue("${0}")
            }
        }.start()
    }

    fun continueTimer(context : Context){
        val spTimer = context.getSharedPreferences("KEY_TIMER", 0)


    }



}