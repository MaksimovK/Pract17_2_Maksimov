package com.example.pract17_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoActivity : AppCompatActivity() {
    private lateinit var exitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        exitButton = findViewById(R.id.exit)

        exitButton.setOnClickListener {
            finish()
        }
    }
}