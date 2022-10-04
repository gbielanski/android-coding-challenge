package com.greg.codingchallenge.domain

import com.greg.codingchallenge.data.ShiftsApi
import javax.inject.Inject

internal class ShiftService @Inject constructor(
    private val api: ShiftsApi,
    private val mapShiftItem: ShiftItemMapper,
) {
    suspend fun shifts(address: String = ADDRESS, start: String, end: String, type: String = TYPE_LIST): List<ShiftItem> {
        return api.shifts(address, start, end, type).data.flatMap { date ->
            date.shifts.map { mapShiftItem(it) }
        }
    }
}

private const val ADDRESS = "Dallas, TX"
private const val TYPE_LIST = "list"