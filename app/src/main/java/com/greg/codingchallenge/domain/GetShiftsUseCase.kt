package com.greg.codingchallenge.domain

import com.greg.codingchallenge.data.ShiftsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDateTime
import javax.inject.Inject

internal class GetShiftsUseCase @Inject constructor(
    private val shiftsRepository: ShiftsRepository,
    private val ioDispatcher: CoroutineDispatcher,
) {

    operator fun invoke(startDay: String? = null): Flow<List<ShiftItem>> {
        val start = if (startDay.isNullOrEmpty()) {
            getCurrentDayTime()
        } else {
            beginningOfNextWeek(startDay)
        }

        val end = getEndOfTheWeek(start)
        return flow {
            emit(shiftsRepository.getShifts(start.toString(), end.toString()))
        }.flowOn(ioDispatcher)
    }


    private fun beginningOfNextWeek(startDay: String) =
        getEndOfTheWeek(startDay.toDateTimeString()).plusMinutes(1)

    private fun String.toDateTimeString(): LocalDateTime {
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
