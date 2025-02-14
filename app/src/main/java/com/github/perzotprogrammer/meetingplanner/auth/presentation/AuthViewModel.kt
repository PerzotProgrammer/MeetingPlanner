package com.github.perzotprogrammer.meetingplanner.auth.presentation

import androidx.lifecycle.ViewModel
import com.github.perzotprogrammer.meetingplanner.auth.presentation.model.AuthDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    private val _authDataState = MutableStateFlow(AuthDataState())
    val authDataState: StateFlow<AuthDataState> = _authDataState

}


