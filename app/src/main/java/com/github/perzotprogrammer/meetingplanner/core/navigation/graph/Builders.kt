package com.github.perzotprogrammer.meetingplanner.core.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.LoginScreen
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.RegisterScreen
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.WelcomeScreen
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.NavigationTree
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.Screen
import com.github.perzotprogrammer.meetingplanner.main.presentation.ui.HomeScreen

fun NavGraphBuilder.authGraph(navHostController: NavHostController) {
    navigation<NavigationTree.Auth>(startDestination = Screen.Welcome) {
        composable<Screen.Welcome> {
            WelcomeScreen(navHostController)
        }
        composable<Screen.Login> {
            LoginScreen(navHostController)
        }
        composable<Screen.Register> {
            RegisterScreen(navHostController)
        }
    }
}

fun NavGraphBuilder.mainGraph(navHostController: NavHostController) {
    navigation<NavigationTree.Main>(startDestination = Screen.Home) {
        composable<Screen.Home> {
            HomeScreen(navHostController)
        }
    }
}