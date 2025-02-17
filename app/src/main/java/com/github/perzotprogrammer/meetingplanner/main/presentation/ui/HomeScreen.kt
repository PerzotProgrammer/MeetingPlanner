package com.github.perzotprogrammer.meetingplanner.main.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.NavigationTree
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.Screen
import com.github.perzotprogrammer.meetingplanner.core.presentation.model.DataResult
import com.github.perzotprogrammer.meetingplanner.main.presentation.MainViewModel

@Composable
fun HomeScreen(navHostController: NavHostController, mainViewModel: MainViewModel) {

    var dataResult by remember { mutableStateOf<DataResult>(DataResult.Loading) }

    Scaffold(modifier = Modifier.fillMaxWidth()) { innerPadding ->
        when (dataResult) {
            DataResult.Loading -> {
                LaunchedEffect(mainViewModel.currentUser) {
                    dataResult = if (mainViewModel.currentUser == null) {
                        DataResult.Error
                    } else {
                        DataResult.Success
                    }
                }
            }

            DataResult.Success -> {
                Column(modifier = Modifier.padding(innerPadding)) {
                    Text(
                        text = "Hello, ${mainViewModel.currentUser?.email}",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        onClick = {
                            mainViewModel.writeToDatabase()
                        }
                    ) {
                        Text(text = "Write to database")
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        onClick = {
                            mainViewModel.logOut()
                            navHostController.navigate(Screen.Welcome) {
                                popUpTo(NavigationTree.Main) {
                                    inclusive = true
                                }
                            }
                        }
                    ) {
                        Text(text = "Log out")
                    }
                }
            }

            DataResult.Error -> {
                Text(
                    text = "An error occurred",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}