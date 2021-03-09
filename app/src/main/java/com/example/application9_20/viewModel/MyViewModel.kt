package com.example.application9_20.viewModel

import android.content.Context
import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.application9_20.model.DataManager

class MyViewModel(
) : ViewModel(){

    val viewText = MutableLiveData<String>()
    lateinit var timer : CountDownTimer

    private fun getTimer(millisInFuture : Long) : CountDownTimer{
        return object : CountDownTimer(millisInFuture, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                viewText.postValue("${millisUntilFinished / 1000}")
            }
            override fun onFinish() {
                viewText.postValue("${0}")
            }
        }
    }

    fun startTimer(){
        timer.cancel()
        timer = getTimer(20000)
        timer.start()
    }

    fun continueTimer(datamanager : DataManager, context : Context){
        //timer.cancel()
        val num = datamanager.getCurrentTime().toLong()*1000

        if (num == 0.toLong()){
            return
        }
        else{
            timer = getTimer(num)
            timer.start()

        }
    }



}