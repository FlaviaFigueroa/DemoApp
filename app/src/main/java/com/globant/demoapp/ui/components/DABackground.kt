package com.globant.demoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.globant.demoapp.ui.manager.ThemeTypes
import com.globant.demoapp.ui.general.SetTheme

/**
 *    Created by Flavia Figueroa
 *    Globant, Lima, Perú
 *    Copyright (c) 2021 Globant. All rights reserved.
 */

@Composable
fun DABackground(backgroundColor: Color, btnAction: SetTheme) {

    val bgColor = remember {
        mutableStateOf(backgroundColor)
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize().background(bgColor.value)) {
        val (btn1, btn2, btn3) = createRefs()

        DAButton("LIGHT", Modifier.constrainAs(btn1){
            this.linkTo(parent.top, parent.bottom, topMargin = 24.dp, bottomMargin = 24.dp, bias = 1.0F)
        }){
            btnAction(ThemeTypes.LIGHT, bgColor)
        }
        DAButton("AS SYSTEM", Modifier.constrainAs(btn2){
            this.linkTo(btn1.top, btn1.bottom)
        }){
            btnAction(ThemeTypes.NONE, bgColor)
        }
        DAButton("DARK", Modifier.constrainAs(btn3){
            this.linkTo(btn2.top, btn2.bottom)
        }){
            btnAction(ThemeTypes.DARK, bgColor)
        }

        createHorizontalChain(btn1, btn2, btn3)

    }

}