package com.example.songbird.modernandroidapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.songbird.modernandroidapp.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        launchFragment()
    }

    abstract fun launchFragment()
}
