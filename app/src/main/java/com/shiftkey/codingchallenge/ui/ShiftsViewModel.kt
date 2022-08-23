package com.shiftkey.codingchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiftkey.codingchallenge.domain.GetShiftsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ShiftsViewModel @Inject constructor(
    private val getShiftsUseCase: GetShiftsUseCase,
) : ViewModel() {
    private val mutableUiState = MutableStateFlow(ShiftsUiState())
    val uiState: StateFlow<ShiftsUiState> = mutableUiState

    init {
        viewModelScope.launch {
            fetchShifts()
        }
    }

    fun lastReached() {
        viewModelScope.launch {
            fetchShifts(uiState.value.shifts.last().startTime)
        }
    }

    private suspend fun fetchShifts(startTime: String? = null) {
        getShiftsUseCase(startTime)
            .onStart { mutableUiState.update { it.copy(isLoading = true) } }
            .catch {
                handleErrors(it)
            }
            .collectLatest { items ->
                if ((mutableUiState.value.shifts + items).isEmpty()) {
                    mutableUiState.update {
                        it.copy(isLoading = false, error = "No shifts available")
                    }
                } else {
                    mutableUiState.update {
                        it.copy(isLoading = false, error = null, shifts = it.shifts + items)
                    }
                }
            }
    }

    private fun handleErrors(error: Throwable) {
        mutableUiState.update { it.copy(isLoading = false, error = error.message) }
    }
}
