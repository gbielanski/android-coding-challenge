package com.shiftkey.codingchallenge.ui

import com.shiftkey.codingchallenge.domain.GetShiftsUseCase
import com.shiftkey.codingchallenge.relaxedMockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

internal class ShiftsViewModelTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val getShiftsUseCase: GetShiftsUseCase = relaxedMockk()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should get shifts when created`() = runTest {
        ShiftsViewModel(getShiftsUseCase)
        this.advanceUntilIdle()

        verify {
            getShiftsUseCase.invoke(any())
        }
    }
}
