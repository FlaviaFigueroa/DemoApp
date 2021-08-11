package com.globant.demoapp.di

import android.content.Context

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

object Injector {
    lateinit var appContext: Context

    fun setUp(context: Context){
        this.appContext = context
    }
}