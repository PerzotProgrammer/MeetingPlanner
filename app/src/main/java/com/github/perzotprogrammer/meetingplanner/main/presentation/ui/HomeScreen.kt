package com.github.perzotprogrammer.meetingplanner.main.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.NavigationTree
import com.github.perzotprogrammer.meetingplanner.core.navigation.model.Screen
import com.github.perzotprogrammer.meetingplanner.core.presentation.model.DataResult
import com.github.perzotprogrammer.meetingplanner.core.repository.data.MeetingDto
import com.github.perzotprogrammer.meetingplanner.main.presentation.MainViewModel

@Composable
fun HomeScreen(navHostController: NavHostController) {

    val mainViewModel = hiltViewModel<MainViewModel>()
    val dataResult by remember { mainViewModel.dataResult }

    Scaffold(modifier = Modifier.fillMaxWidth()) { innerPadding ->
        when (dataResult) {
            DataResult.Loading -> {
                Column(
                    modifier = Modifier.padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Loading...",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding),
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center
                    )
                }
            }

            DataResult.Error -> {
                Column(
                    modifier = Modifier.padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
                            mainViewModel.addMeeting(
                                MeetingDto(
                                    title = "Meeting",
                                    description = "Description",
                                    date = "Date",
                                    time = "Time",
                                    duration = 1,
                                    location = "Location",
                                    participants = listOf("Test1", "Test2", "Test3")
                                )
                            )
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
        }
    }
}