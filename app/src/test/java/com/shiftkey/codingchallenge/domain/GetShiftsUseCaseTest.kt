package com.shiftkey.codingchallenge.domain

import com.shiftkey.codingchallenge.data.ShiftsRepository
import com.shiftkey.codingchallenge.relaxedMockk
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Test

internal class GetShiftsUseCaseTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val coroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher(
        TestCoroutineScheduler()
    )
    private val shiftsRepository: ShiftsRepository = relaxedMockk()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get shifts should get shifts from repository`() = runTest {
        val startDate = "someDate"
        val useCase = GetShiftsUseCase(
            shiftsRepository = shiftsRepository,
            ioDispatcher = coroutineDispatcher
        )

        useCase.invoke(startDate).collect(relaxedMockk())

        coVerify {
            shiftsRepository.getShifts(startDate)
        }
    }
}
