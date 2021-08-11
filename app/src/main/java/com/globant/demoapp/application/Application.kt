package com.globant.demoapp.application

import android.app.Application
import android.content.Context
import com.globant.demoapp.di.Injector
import com.globant.demoapp.ui.manager.PREFERENCES_NAME
import com.globant.demoapp.ui.manager.THEME_KEY
import com.globant.demoapp.ui.manager.ThemeManager
import com.globant.demoapp.ui.manager.ThemeTypes

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        Injector.setUp(this)

        initTheme()
    }

    private fun initTheme(){
        val savedTheme = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).getString(THEME_KEY, null)
        ThemeManager.settings.updateTheme(ThemeTypes.getByTheme(savedTheme))
    }
}