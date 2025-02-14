package com.github.perzotprogrammer.meetingplanner.core.navigation.graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.github.perzotprogrammer.meetingplanner.auth.presentation.AuthViewModel
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.Navigation

@Composable
fun MainNavGraph() {
    val navHostController = rememberNavController()
    val authViewModel = hiltViewModel<AuthViewModel>()
    NavHost(navHostController, startDestination = Navigation.Auth) {
        authGraph(navHostController, authViewModel)
        mainGraph(navHostController)
    }
}

