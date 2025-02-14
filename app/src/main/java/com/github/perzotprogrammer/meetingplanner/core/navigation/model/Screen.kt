package com.github.perzotprogrammer.meetingplanner.core.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Welcome : Screen()

    @Serializable
    data object Login : Screen()

    @Serializable
    data object Register : Screen()

    @Serializable
    data object Home : Screen()
}