package com.github.perzotprogrammer.meetingplanner.auth.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.github.perzotprogrammer.meetingplanner.auth.presentation.AuthViewModel
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.common.AuthModifiers
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.common.EmailField
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.common.PasswordField
import com.github.perzotprogrammer.meetingplanner.core.presentation.model.DataResult
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navHostController: NavHostController, authViewModel: AuthViewModel) {
    val authDataStore = authViewModel.authDataState.collectAsStateWithLifecycle().value
    val emailTextField = authDataStore.emailField
    val passwordTextField = authDataStore.passwordField
    val repeatPasswordTextField = authDataStore.repeatPasswordField
    val isPasswordVisible = authDataStore.isPasswordVisible



    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Enter your credentials for registration",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = AuthModifiers.spacer())
            EmailField(
                emailTextField = emailTextField,
                label = "Email"
            )
            PasswordField(
                passwordTextField = passwordTextField,
                isPasswordVisible = isPasswordVisible,
                label = "Password"
            )
            PasswordField(
                passwordTextField = repeatPasswordTextField,
                isPasswordVisible = isPasswordVisible,
                label = "Repeat password",
                iconVisibility = false
            )
            Spacer(modifier = AuthModifiers.spacer())
            val context = LocalContext.current
            Button(
                modifier = AuthModifiers.button(),
                onClick = {
                    authViewModel.viewModelScope.launch {
                        when (authViewModel.createUserWithEmailAndPassword(
                            emailTextField.value,
                            passwordTextField.value
                        )) {
                            DataResult.Error -> {
                                Toast.makeText(context, "User creation failed.", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            DataResult.Success -> {
                                Toast.makeText(context, "User created!", Toast.LENGTH_SHORT).show()
                                navHostController.navigateUp()
                            }

                            DataResult.Loading -> {}
                        }
                    }

                }
            ) {
                Text(
                    text = "Register",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Button(
                modifier = AuthModifiers.button(),
                onClick = {
                    navHostController.navigateUp()
                }
            ) {
                Text(
                    text = "Go back",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}