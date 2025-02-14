package com.github.perzotprogrammer.meetingplanner.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.perzotprogrammer.meetingplanner.app.theme.MeetingPlannerTheme
import com.github.perzotprogrammer.meetingplanner.core.navigation.graph.MainNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeetingPlannerTheme {
                MainNavGraph()
            }
        }
    }
}
