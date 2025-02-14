package com.github.perzotprogrammer.meetingplanner.auth.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.github.perzotprogrammer.meetingplanner.auth.presentation.AuthViewModel
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.Screen

@Composable
fun WelcomeScreen(navHostController: NavHostController, authViewModel: AuthViewModel) {

    val authDataStore = authViewModel.authDataState.collectAsStateWithLifecycle()
    var testTextField by authDataStore.value.testTextFieldContent

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Welcome",
                style = MaterialTheme.typography.headlineMedium
            )
            TextField(
                value = testTextField,
                onValueChange = { testTextField = it },
                label = {
                    Text("Testing Input")
                }
            )
            Button(onClick = {
                navHostController.navigate(Screen.Login)
            }) {
                Text("Login")
            }
        }
    }
}