package com.github.perzotprogrammer.meetingplanner.auth.presentation.model

import androidx.compose.runtime.mutableStateOf

data object AuthDataState {
    val emailField = mutableStateOf("")
    val passwordField = mutableStateOf("")
    val isPasswordVisible = mutableStateOf(false)
    val repeatPasswordField = mutableStateOf("")
}