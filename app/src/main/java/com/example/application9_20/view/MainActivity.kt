package com.example.application9_20.view

import android.accounts.AccountManager.KEY_PASSWORD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.application9_20.R
import com.example.application9_20.model.DataManager
import com.example.application9_20.viewModel.MyViewModel


class MainActivity : AppCompatActivity() {

    private val rightPassword = "1922196"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model  = ViewModelProvider(this).get(MyViewModel :: class.java)
        val sp = getSharedPreferences(KEY_PASSWORD, 0)
        val spTimer = getSharedPreferences("KEY_TIMER", 0)
        //spTimer.edit().putString("KEY_TIMER", "0").apply()
        //findViewById<TextView>(R.id.tv_timer).text = " "

        model.viewText.observe(this, Observer<String> {
            findViewById<TextView>(R.id.tv_timer).text = it
            spTimer.edit().putString("KEY_TIMER", it).apply()
        })

        model.continueTimer(DataManager(this.baseContext),this.baseContext)

        findViewById<Button>(R.id.btn_check).setOnClickListener{

            sp.edit().putString(KEY_PASSWORD, findViewById<EditText>(R.id.et_password).text.toString()).apply()
            if (rightPassword.compareTo(sp.getString(KEY_PASSWORD," ").toString()) == 0){
                findViewById<TextView>(R.id.tv_rezult).text = "Your password is right!"
            }
            else{
                findViewById<TextView>(R.id.tv_rezult).text = "Your password is wrong!"
                model.getTimer() 
            }
        }

    }



}