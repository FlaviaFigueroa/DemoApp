package com.globant.demoapp.ui

import android.content.Context
import com.globant.demoapp.entities.Color
import com.globant.demoapp.ui.manager.ThemeManager
import com.globant.demoapp.ui.manager.ThemeTypes
import org.json.JSONObject
import java.io.IOException

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

interface IDemo {
    var color  : Color

    fun getJson(context: Context): Color {
        val jsonString: String
        return try {
            jsonString = context.assets.open("colors.json").bufferedReader().use { it.readText() }
            this.color = Color(JSONObject(jsonString).get("Variables") as? JSONObject ?: JSONObject())
            this.color
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            Color()
        }
    }

    fun setUpTheme(theme: ThemeTypes){
        if (theme == ThemeTypes.NONE) ThemeManager.settings.backToSystemTheme()
        else ThemeManager.settings.saveCustomTheme(theme)
    }
}