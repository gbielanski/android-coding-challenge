package com.shiftkey.codingchallenge.data

import com.shiftkey.codingchallenge.domain.ShiftItem
import java.time.LocalDateTime
import javax.inject.Inject

internal class ShiftsRepository @Inject constructor(
    private val shiftsApi: ShiftsApi
) {
    suspend fun getShifts(startDay: String?): List<ShiftItem> {
        val start = startDay ?: getCurrentDayTime()
        val end = getEndOfTheWeek(start)
        val response = shiftsApi.shifts(
            address = ADDRESS,
            start = start,
            end = end,
            type = TYPE
        )
        return response.data.flatMap { date ->
            date.shifts.map { ShiftItem(it) }
        }
    }

    private fun getEndOfTheWeek(start: String): String {
        val today = LocalDateTime.parse(start)

        val daysToEndOfTheWeek = 7 - today.dayOfWeek.value

        return today.plusDays(daysToEndOfTheWeek.toLong()).withHour(23).withMinute(59).toString()
    }

    private fun getCurrentDayTime(): String {
        return LocalDateTime.now().toString()
    }
}

private const val ADDRESS = "Dallas, TX"
private const val TYPE = "list"
