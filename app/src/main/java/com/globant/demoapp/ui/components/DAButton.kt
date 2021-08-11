package com.globant.demoapp.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import com.globant.demoapp.ui.general.Action

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

@Composable
fun DAButton(text: String, modifier: Modifier = Modifier, onClick: Action) {
    Button(onClick, modifier){
        Text(text)
    }
}