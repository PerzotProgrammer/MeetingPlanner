package com.github.perzotprogrammer.meetingplanner.core.navigation.graph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.github.perzotprogrammer.meetingplanner.auth.presentation.AuthViewModel
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.NavigationTree

@Composable
fun MainNavGraph() {
    val navHostController = rememberNavController()
    val authViewModel = hiltViewModel<AuthViewModel>()
    val animationDuration = 1000
    NavHost(navHostController, startDestination = NavigationTree.Auth,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Up,
                tween(animationDuration)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Up,
                tween(animationDuration)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
                tween(animationDuration)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
                tween(animationDuration)
            )
        }
    ) {
        authGraph(navHostController, authViewModel)
        mainGraph(navHostController)
    }
}

