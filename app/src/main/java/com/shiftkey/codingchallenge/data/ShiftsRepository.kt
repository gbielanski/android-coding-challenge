package com.shiftkey.codingchallenge.data

import com.shiftkey.codingchallenge.domain.ShiftItem
import java.time.LocalDateTime
import javax.inject.Inject

internal class ShiftsRepository @Inject constructor(
    private val shiftsApi: ShiftsApi
) {
    suspend fun getShifts(startDay: String?): List<ShiftItem> {
        val start = if (startDay.isNullOrEmpty()) {
            getCurrentDayTime()
        } else {
            getEndOfTheWeek(startDay.toLocalDateTime()).plusMinutes(1)
        }

        val end = getEndOfTheWeek(start)
        val response = shiftsApi.shifts(
            address = ADDRESS,
            start = start.toString(),
            end = end.toString(),
            type = TYPE_LIST
        )
        return response.data.flatMap { date ->
            date.shifts.map { ShiftItem(it) }
        }
    }

    private fun String.toLocalDateTime(): LocalDateTime {
        return LocalDateTime.parse(
            if (contains("+")) {
                substring(0, indexOf("+"))
            } else {
                this
            }
        )
    }

    private fun getEndOfTheWeek(day: LocalDateTime): LocalDateTime {
        val daysToEndOfTheWeek = 7 - day.dayOfWeek.value
        return day.plusDays(daysToEndOfTheWeek.toLong())
            .withHour(23)
            .withMinute(59)
            .withSecond(0)
            .withNano(0)
    }

    private fun getCurrentDayTime(): LocalDateTime {
        return LocalDateTime.now()
    }
}

private const val ADDRESS = "Dallas, TX"
private const val TYPE_LIST = "list"
