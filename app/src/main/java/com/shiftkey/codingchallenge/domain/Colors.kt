package com.shiftkey.codingchallenge.domain

import androidx.compose.ui.graphics.Color

fun String.toComposeColor(): Color = Color(android.graphics.Color.parseColor(this))