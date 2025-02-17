package com.github.perzotprogrammer.meetingplanner.auth.presentation.ui

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.github.perzotprogrammer.meetingplanner.auth.presentation.AuthViewModel
import com.github.perzotprogrammer.meetingplanner.auth.presentation.ui.common.AuthModifiers
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.NavigationTree
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.Screen

@Composable
fun WelcomeScreen(navHostController: NavHostController, authViewModel: AuthViewModel) {


    // TODO: Przemyśleć lepszy system przekierowywania
    LaunchedEffect(Unit) {
        if (authViewModel.isUserSignIn()) {
            navHostController.navigate(NavigationTree.Main) {
                popUpTo(Screen.Welcome) {
                    inclusive = true
                }
            }
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to Meeting Planner!",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = AuthModifiers.spacer())
            Button(
                modifier = AuthModifiers.button(),
                onClick = {
                    navHostController.navigate(Screen.Login)
                }) {
                Text(
                    text = "Log in to your account",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Button(
                modifier = AuthModifiers.button(),
                onClick = {
                    navHostController.navigate(Screen.Register)
                }) {
                Text(
                    text = "Create a new account",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}