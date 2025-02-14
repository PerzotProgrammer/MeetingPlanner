package com.github.perzotprogrammer.meetingplanner.auth.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.github.perzotprogrammer.meetingplanner.auth.presentation.AuthViewModel

@Composable
fun LoginScreen(navHostController: NavHostController, authViewModel: AuthViewModel) {

    val authDataStore = authViewModel.authDataState.collectAsStateWithLifecycle()
    val testTextField by authDataStore.value.testTextFieldContent

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Hello, $testTextField",
                style = MaterialTheme.typography.headlineMedium
            )

            Button(onClick = {
                navHostController.navigateUp()
            }) {
                Text("Go back")
            }
        }
    }
}