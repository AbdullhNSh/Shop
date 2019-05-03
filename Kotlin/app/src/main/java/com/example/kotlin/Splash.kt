package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class Splash : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}