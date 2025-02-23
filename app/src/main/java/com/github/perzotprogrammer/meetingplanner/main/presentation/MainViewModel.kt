package com.github.perzotprogrammer.meetingplanner.main.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.perzotprogrammer.meetingplanner.core.presentation.model.DataResult
import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseAuthRepository
import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseDataStorageRepository
import com.github.perzotprogrammer.meetingplanner.core.repository.data.MeetingDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository,
    private val firebaseDataStorageRepository: FirebaseDataStorageRepository
) : ViewModel() {

    val currentUser = firebaseAuthRepository.getCurrentUser()
    val dataResult = mutableStateOf<DataResult>(DataResult.Loading).apply {
        value = if (currentUser == null) DataResult.Error
        else DataResult.Success
    }

    fun logOut() {
        firebaseAuthRepository.logOut()
    }

    fun addMeeting(meetingDto: MeetingDto) {
        viewModelScope.launch {
            firebaseDataStorageRepository.addMeeting(meetingDto)
        }
    }
}