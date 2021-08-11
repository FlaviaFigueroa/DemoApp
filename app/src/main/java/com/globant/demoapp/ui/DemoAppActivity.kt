package com.globant.demoapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globant.demoapp.databinding.ActivityDemoAppBinding

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

class DemoAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding()
        onClickEvents()
    }

    private fun binding(){
        this.binding = ActivityDemoAppBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }

    private fun onClickEvents(){
        this.binding.btnCompose.setOnClickListener {
            startActivity(Intent(this, DemoComposeActivity::class.java))
        }

        this.binding.btnXML.setOnClickListener {
            startActivity(Intent(this, DemoXMLActivity::class.java))
        }
    }
}