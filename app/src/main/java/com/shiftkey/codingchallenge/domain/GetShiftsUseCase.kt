package com.shiftkey.codingchallenge.domain

import com.shiftkey.codingchallenge.data.ShiftsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetShiftsUseCase @Inject constructor(
    private val shiftsRepository: ShiftsRepository,
    private val ioDispatcher: CoroutineDispatcher,
) {

    operator fun invoke(): Flow<List<ShiftItem>> = flow {
        emit(shiftsRepository.getShifts(null, END))
    }.flowOn(ioDispatcher)
}

private const val END = "2022-08-21T18:00:00+00:00"
