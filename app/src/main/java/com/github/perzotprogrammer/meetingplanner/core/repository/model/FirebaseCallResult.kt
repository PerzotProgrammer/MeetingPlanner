package com.github.perzotprogrammer.meetingplanner.core.repository.model

sealed interface FirebaseCallResult<out T> {
    data class Success<T>(val data: T) : FirebaseCallResult<T>
    data class Error(val message: String) : FirebaseCallResult<Nothing>
}