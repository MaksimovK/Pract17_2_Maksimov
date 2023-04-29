package com.example.pract17_2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.IDNA.Info
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.System.load

class MainActivity : AppCompatActivity() {
    private lateinit var pinEditText: EditText
    private lateinit var nextButton: Button
    lateinit var getPin: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPin = getPreferences(MODE_PRIVATE)
        pinEditText = findViewById(R.id.pin)
        nextButton = findViewById(R.id.next)

       /* val ed:SharedPreferences.Editor = getPin.edit()
        ed.remove("pin")
        ed.apply()*/

        if(getPin.getString("pin","").isNullOrEmpty())
            nextButton.text = "Зарегистрироваться"
        else
            nextButton.text = "Войти"

    }

    fun Login(view: View) {
        getPin = getPreferences(MODE_PRIVATE)
        val ed:SharedPreferences.Editor = getPin.edit()
        if(CheckPass()){
            if(nextButton.text == "Зарегистрироваться") {
                ed.putString("pin", pinEditText.text.toString())
                ed.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                if (getPin.getString("pin", "") == pinEditText.text.toString()) {
                    val intent = Intent(this, InfoActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Неверный пинкод", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun CheckPass():Boolean {
        for (char in pinEditText.text) {
            if (!char.isDigit()) {
                Toast.makeText(this, "Пин код может состоять только из цифр", Toast.LENGTH_SHORT)
                    .show()
                return false
            }
        }
        return true
    }
}