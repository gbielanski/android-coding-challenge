package com.shiftkey.codingchallenge.ui

import android.util.Log
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
            Log.d("Greg", "ShiftsViewModel")
            getShiftsUseCase()
                .onStart { mutableUiState.update { it.copy(isLoading = true) } }
                .catch {
                    Log.d("Greg", "ShiftsViewModel error")
                    handleErrors(it) }
                .collectLatest { items ->
                    mutableUiState.update {
                        it.copy(isLoading = false, error = null, shifts = items)
                    }
                }
        }
    }

    private fun handleErrors(error: Throwable) {
        mutableUiState.update { it.copy(isLoading = false, error = error.message) }
    }
}