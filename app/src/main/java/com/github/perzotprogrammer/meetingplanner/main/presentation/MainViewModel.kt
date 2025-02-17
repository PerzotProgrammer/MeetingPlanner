package com.github.perzotprogrammer.meetingplanner.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseAuthRepository
import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseDataStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository,
    private val firebaseDataStorageRepository: FirebaseDataStorageRepository
) : ViewModel() {

    val currentUser = firebaseAuthRepository.getCurrentUser()

    fun logOut() {
        firebaseAuthRepository.logOut()
    }

    fun writeToDatabase() {
        viewModelScope.launch {
            firebaseDataStorageRepository.writeCurrentUser()
        }
    }
}