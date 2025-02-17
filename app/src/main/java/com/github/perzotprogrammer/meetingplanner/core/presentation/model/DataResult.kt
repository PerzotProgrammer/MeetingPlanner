package com.github.perzotprogrammer.meetingplanner.core.presentation.model

sealed interface DataResult {
    data object Loading : DataResult
    data object Error : DataResult
    data object Success : DataResult
}