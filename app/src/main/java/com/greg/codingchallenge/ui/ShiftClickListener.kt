package com.greg.codingchallenge.ui

import com.greg.codingchallenge.domain.ShiftItem

internal interface ShiftClickListener {
    fun onShiftClicked(item: ShiftItem)
}
