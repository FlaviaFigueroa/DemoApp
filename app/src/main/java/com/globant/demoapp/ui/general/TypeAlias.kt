package com.globant.demoapp.ui.general

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.globant.demoapp.ui.manager.ThemeTypes

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

typealias Action = () -> Unit
typealias SetTheme = (themeType: ThemeTypes, color: MutableState<Color>) -> Unit