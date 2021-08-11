package com.globant.demoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.globant.demoapp.entities.Color
import com.globant.demoapp.ui.components.DABackground

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

class DemoComposeActivity: ComponentActivity(), IDemo {

    override lateinit var color: Color

    private val bgColor: androidx.compose.ui.graphics.Color
        get() {
            return androidx.compose.ui.graphics.Color(android.graphics.Color.parseColor(this.color.textColor))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getJson(this)
            SetUpUI()
        }
    }

    @Preview
    @Composable
    private fun SetUpUI(){
        DABackground(this.bgColor){ themeType, color ->
            setUpTheme(themeType)
            color.value = this.bgColor
        }
    }
}