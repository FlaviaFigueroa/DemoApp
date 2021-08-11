package com.globant.demoapp.entities

import com.globant.demoapp.ui.manager.ThemeManager
import com.globant.demoapp.ui.manager.ThemeTypes
import org.json.JSONObject

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

data class Color(private val jsonObject: JSONObject?= null){
    private val lightTextColor  = jsonObject?.optString("lightTextColor")   ?: ""
    private val darkGrayColor   = jsonObject?.optString("darkGrayColor")    ?: ""

    val textColor: String
        get() {
            return if (ThemeManager.settings.getCurrentTheme() == ThemeTypes.LIGHT) lightTextColor else darkGrayColor
        }
}