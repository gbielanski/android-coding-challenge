package com.shiftkey.codingchallenge.ui

import com.shiftkey.codingchallenge.domain.ShiftItem

internal interface ShiftClickListener {
    fun onShiftClicked(item: ShiftItem)
}
