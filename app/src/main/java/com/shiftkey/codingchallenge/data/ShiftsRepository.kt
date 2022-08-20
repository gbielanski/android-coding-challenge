package com.shiftkey.codingchallenge.data

import com.shiftkey.codingchallenge.domain.ShiftItem
import javax.inject.Inject

internal class ShiftsRepository @Inject constructor(
    private val shiftsApi: ShiftsApi
) {
    suspend fun getShifts(): List<ShiftItem> {
        val response = shiftsApi.shifts(address = ADDRESS, start = START, type = TYPE)
        return response.data.flatMap { date ->
            date.shifts.map { ShiftItem(it) }
        }
    }
}

private const val ADDRESS = "Dallas, TX"
private const val TYPE = "list"
private const val START = "2022-08-20T15:00:00+00:00"