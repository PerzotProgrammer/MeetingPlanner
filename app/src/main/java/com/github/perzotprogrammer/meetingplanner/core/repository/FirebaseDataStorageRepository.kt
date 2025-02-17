package com.github.perzotprogrammer.meetingplanner.core.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseDataStorageRepository {

    private val _db = Firebase.database.reference
    private val _currentUser = Firebase.auth.currentUser

    // TODO: OGARNĄĆ TO
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
}