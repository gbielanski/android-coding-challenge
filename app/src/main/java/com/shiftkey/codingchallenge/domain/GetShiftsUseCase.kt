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

    operator fun invoke(startDay: String? = null): Flow<List<ShiftItem>> = flow {
        emit(shiftsRepository.getShifts(startDay))
    }.flowOn(ioDispatcher)
}