package com.github.perzotprogrammer.meetingplanner.core.navigation.graph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.NavigationTree
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun MainNavGraph() {
    val navHostController = rememberNavController()
    val animationDuration = 1000
    val startingScreen =
        if (Firebase.auth.currentUser == null) NavigationTree.Auth
        else NavigationTree.Main

    NavHost(navHostController, startDestination = startingScreen,
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
        authGraph(navHostController)
        mainGraph(navHostController)
    }
}

