package com.shiftkey.codingchallenge.data

import com.shiftkey.codingchallenge.domain.ShiftItem
import com.shiftkey.codingchallenge.domain.ShiftService
import javax.inject.Inject

internal class ShiftsRepository @Inject constructor(
    private val shiftService: ShiftService
) {
    suspend fun getShifts(start: String, end: String): List<ShiftItem> {
        return shiftService.shifts(start = start, end = end)
    }
}
