package com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailField(
    emailTextField: MutableState<String>,
    label: String,
) {
    var emailValue by emailTextField
    TextField(
        modifier = AuthModifiers.textField(),
        value = emailValue,
        onValueChange = {
            emailValue = it.trim(' ', '\n', '\t')
        },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}