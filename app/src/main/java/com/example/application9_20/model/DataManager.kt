package com.example.application9_20.model

import android.accounts.AccountManager.KEY_PASSWORD
import android.content.Context

class DataManager (
    val context: Context
){

    fun getCurrentTime():String{
        val sp = context.getSharedPreferences("KEY_TIMER", 0)
        return sp.getString("KEY_TIMER","0").toString()
    }

    fun getPassword(): String {
        Thread.sleep(1000)
        val sp = context.getSharedPreferences(KEY_PASSWORD, 0)
        return sp.getString(KEY_PASSWORD,"").toString()
    }
}