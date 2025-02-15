package com.github.perzotprogrammer.meetingplanner.core.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationTree {
    @Serializable
    data object Auth : NavigationTree()
    
    @Serializable
    data object Main : NavigationTree()
}