package com.globant.demoapp.ui.manager

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import com.globant.demoapp.di.Injector

/**
 *  @author Flavia Figueroa
 */

class ThemeManager private constructor(){

    private val sharedPreference =  Injector.appContext.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    /**
     *    Created by Flavia Figueroa
     *    Globant, Lima, Perú
     *    Copyright (c) 2021 Globant. All rights reserved.
     */
    companion object{
        private var internalSettings = ThemeManager()
        val settings: ThemeManager
            get() {
                return internalSettings
            }
    }

    fun getCurrentTheme(): ThemeTypes {
        val currentNightMode = Injector.appContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {
                println("System theme in Light")
                ThemeTypes.getByTheme(this.sharedPreference.getString(THEME_KEY, null)) ?: ThemeTypes.LIGHT
            }
            else -> {
                println("System theme in Dark")
                ThemeTypes.getByTheme(this.sharedPreference.getString(THEME_KEY, null)) ?: ThemeTypes.DARK
            }
        }
    }

    fun saveCustomTheme(theme: ThemeTypes){
        val editor = sharedPreference.edit()
        editor.putString(THEME_KEY, theme.theme)
        editor.apply()

        updateTheme(theme)
    }

    fun backToSystemTheme(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        this.sharedPreference.edit().clear().apply()
    }

    fun updateTheme(theme: ThemeTypes?){
        theme?.let {
            when(it.theme){
                ThemeTypes.LIGHT.theme  -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                ThemeTypes.DARK.theme   -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
}

enum class ThemeTypes(val theme: String){
    DARK("darkTheme"), LIGHT("lightTheme"), NONE("none");

    companion object{
        fun getByTheme(theme: String?) = values().find { it.theme == theme }
    }
}

const val PREFERENCES_NAME = "THEMES"
const val THEME_KEY = "CURRENT_THEME"