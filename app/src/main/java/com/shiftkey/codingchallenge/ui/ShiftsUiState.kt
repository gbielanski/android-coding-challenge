package com.shiftkey.codingchallenge.ui

import com.shiftkey.codingchallenge.domain.ShiftItem

internal data class ShiftsUiState(
    val isLoading: Boolean = false,
    val shifts: List<ShiftItem> = emptyList(),
    val error: String? = null
)
