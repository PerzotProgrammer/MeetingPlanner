package com.github.perzotprogrammer.meetingplanner.core.repository

import android.util.Log
import com.github.perzotprogrammer.meetingplanner.core.repository.model.FirebaseCallResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class FirebaseAuthRepository {

    private var _auth = Firebase.auth


    fun isUserLoggedIn(): Boolean {
        return _auth.currentUser != null
    }

    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): FirebaseCallResult<FirebaseUser> {
        return try {
            val result = _auth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser = result.user

            return if (firebaseUser != null) FirebaseCallResult.Success(firebaseUser)
            else FirebaseCallResult.Error("Sign up failed")

        } catch (e: Exception) {
            Log.e("FirebaseAuthRepository", e.message.toString())
            FirebaseCallResult.Error("Sign up failed")
        }

    }

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): FirebaseCallResult<FirebaseUser> {
        return try {
            val result = _auth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser = _auth.currentUser

            return if (result.user != null) FirebaseCallResult.Success(firebaseUser!!)
            else FirebaseCallResult.Error("Sign in failed")

        } catch (e: Exception) {
            Log.e("FirebaseAuthRepository", e.message.toString())
            FirebaseCallResult.Error("Sign in failed")
        }

    }

    fun getCurrentUser(): FirebaseUser? {
        return _auth.currentUser
    }

    fun logOut() {
        _auth.signOut()
    }
}