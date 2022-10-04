package com.greg.codingchallenge.ui

import com.greg.codingchallenge.domain.ShiftItem

internal data class ShiftsUiState(
    val isLoading: Boolean = false,
    val shifts: List<ShiftItem> = emptyList(),
    val error: String? = null
)
