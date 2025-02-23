package com.github.perzotprogrammer.meetingplanner.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.github.perzotprogrammer.meetingplanner.auth.presentation.model.AuthDataState
import com.github.perzotprogrammer.meetingplanner.core.presentation.model.DataResult
import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseAuthRepository
import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseDataStorageRepository
import com.github.perzotprogrammer.meetingplanner.core.repository.model.FirebaseCallResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: FirebaseAuthRepository,
    private val dataStorageRepository: FirebaseDataStorageRepository
) : ViewModel() {

    private val _authDataStateFlow = MutableStateFlow(AuthDataState)
    val authDataState: StateFlow<AuthDataState> = _authDataStateFlow
    private val _authDataState = _authDataStateFlow.value

    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): DataResult {
        if (_authDataState.emailField.value.isEmpty() ||
            _authDataState.passwordField.value.isEmpty() ||
            _authDataState.repeatPasswordField.value.isEmpty() ||
            _authDataState.passwordField.value != _authDataState.repeatPasswordField.value
        ) {
            Log.d("AUTH", "Invalid data")
            return DataResult.Error
        }
        return when (authRepository.createUserWithEmailAndPassword(email, password)) {
            is FirebaseCallResult.Error -> DataResult.Error
            is FirebaseCallResult.Success -> {
                dataStorageRepository.writeCurrentUser()
                DataResult.Success
            }
        }
    }

    suspend fun signInWithEmailAndPassword(email: String, password: String): DataResult {
        if (_authDataState.emailField.value.isEmpty() ||
            _authDataState.passwordField.value.isEmpty()
        ) {
            Log.d("AUTH", "Invalid data")
            return DataResult.Error
        }
        return when (authRepository.signInWithEmailAndPassword(email, password)) {
            is FirebaseCallResult.Error -> DataResult.Error
            is FirebaseCallResult.Success -> {
                dataStorageRepository.writeCurrentUser()
                DataResult.Success
            }
        }
    }
}


