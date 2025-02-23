package com.github.perzotprogrammer.meetingplanner.core.repository

import com.github.perzotprogrammer.meetingplanner.core.repository.data.MeetingDto
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseDataStorageRepository {

    private val _db = Firebase.database.reference
    private val _currentUser = Firebase.auth.currentUser

    suspend fun writeCurrentUser() {

        val dbContextRef = _db.child("users")
        dbContextRef.setValue(_currentUser?.uid).addOnSuccessListener {
            dbContextRef.child(_currentUser?.uid!!).setValue(
                mapOf(
                    "email" to _currentUser.email,
                    "name" to _currentUser.displayName
                )
            )

        }.await()
    }

    suspend fun addMeeting(meetingDto: MeetingDto) {
        var dbContextRef = _db.child("meetings")
        dbContextRef.child(meetingDto.hashCode().toString()).setValue(
            mapOf(
                "title" to meetingDto.title,
                "description" to meetingDto.description,
                "date" to meetingDto.date,
                "time" to meetingDto.time,
                "duration" to meetingDto.duration,
                "location" to meetingDto.location,
                "participants" to meetingDto.participants
            )
        ).await()

        dbContextRef = _db.child("users")
            .child(_currentUser?.uid!!)
            .child("meetings")
        dbContextRef.push().setValue(meetingDto.hashCode()).await()
    }
}