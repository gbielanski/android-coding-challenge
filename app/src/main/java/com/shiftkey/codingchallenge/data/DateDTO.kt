package com.shiftkey.codingchallenge.data

import androidx.annotation.Keep

@Keep
internal data class DateDTO(
    val date: String,
    val shifts: List<ShiftItemDTO>,
)
