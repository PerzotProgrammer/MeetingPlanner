package com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordField(
    passwordTextField: MutableState<String>,
    isPasswordVisible: MutableState<Boolean>,
    label: String,
    iconVisibility: Boolean = true,
) {
    var passwordValue by passwordTextField
    var passwordVisibility by isPasswordVisible
    TextField(
        modifier = AuthModifiers.textField(),
        value = passwordValue,
        onValueChange = {
            passwordValue = it.trim(' ', '\n', '\t')
        },
        visualTransformation = if (passwordVisibility)
            VisualTransformation.None
        else {
            PasswordVisualTransformation()
        },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (iconVisibility)
                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility }
                ) {

                    Icon(
                        imageVector = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = "Toggle password visibility"
                    )
                }
        }
    )
}