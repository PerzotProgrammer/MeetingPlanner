package com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object AuthModifiers {
    fun textField() = Modifier
        .fillMaxWidth()
        .padding(8.dp)

    fun spacer() = Modifier.padding(32.dp)

    fun button() = Modifier
        .width(200.dp)
        .padding(8.dp)
}