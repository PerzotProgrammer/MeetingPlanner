package com.github.perzotprogrammer.meetingplanner.core.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.perzotprogrammer.meetingplanner.auth.presentation.AuthViewModel
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.LoginScreen
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.RegisterScreen
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.WelcomeScreen
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.NavigationTree
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.Screen
import com.github.perzotprogrammer.meetingplanner.main.presentation.ui.HomeScreen
import com.github.perzotprogrammer.meetingplanner.main.presentation.MainViewModel

fun NavGraphBuilder.authGraph(navHostController: NavHostController, authViewModel: AuthViewModel) {
    navigation<NavigationTree.Auth>(startDestination = Screen.Welcome) {
        composable<Screen.Welcome> {
            WelcomeScreen(navHostController, authViewModel)
        }
        composable<Screen.Login> {
            LoginScreen(navHostController, authViewModel)
        }
        composable<Screen.Register> {
            RegisterScreen(navHostController, authViewModel)
        }
    }
}

fun NavGraphBuilder.mainGraph(navHostController: NavHostController, mainViewModel: MainViewModel) {
    navigation<NavigationTree.Main>(startDestination = Screen.Home) {
        composable<Screen.Home> {
            HomeScreen(navHostController, mainViewModel)
        }
    }
}