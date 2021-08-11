package com.globant.demoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globant.demoapp.databinding.ActivityMainBinding
import com.globant.demoapp.entities.Color
import com.globant.demoapp.ui.manager.ThemeTypes

class DemoXMLActivity : AppCompatActivity(), IDemo {
    private lateinit var binding: ActivityMainBinding
    override lateinit var color  : Color

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding()
        getJson(this)
        setUpUI()
        switchTheme()
    }

    private fun binding(){
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }

    private fun setUpUI(){
        this.binding.ctrContainer.setBackgroundColor(android.graphics.Color.parseColor(this.color.textColor))
    }

    private fun switchTheme(){
        this.binding.btnLight.setOnClickListener {
            setTheme(ThemeTypes.LIGHT)
        }

        this.binding.btnNone.setOnClickListener {
            setTheme(ThemeTypes.NONE)
        }

        this.binding.btnDark.setOnClickListener {
            setTheme(ThemeTypes.DARK)
        }
    }

    private fun setTheme(theme: ThemeTypes){
        setUpTheme(theme)
        setUpUI()
    }
}