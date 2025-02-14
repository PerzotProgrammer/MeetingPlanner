package com.github.perzotprogrammer.meetingplanner.core.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class Navigation {
    @Serializable
    data object Auth : Navigation()
    @Serializable
    data object Main : Navigation()
}