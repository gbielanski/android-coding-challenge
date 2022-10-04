package com.greg.codingchallenge.domain

import com.greg.codingchallenge.data.ShiftsRepository
import com.greg.codingchallenge.relaxedMockk
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
        val startDate = "2018-12-14T09:55:00"
        val useCase = GetShiftsUseCase(
            shiftsRepository = shiftsRepository,
            ioDispatcher = coroutineDispatcher
        )

        useCase.invoke(startDate).collect(relaxedMockk())

        coVerify {
            shiftsRepository.getShifts(any(), any())
        }
    }
}
