package com.greg.codingchallenge.data

import androidx.annotation.Keep

@Keep
internal data class DateDTO(
    val shifts: List<ShiftItemDTO>,
)
