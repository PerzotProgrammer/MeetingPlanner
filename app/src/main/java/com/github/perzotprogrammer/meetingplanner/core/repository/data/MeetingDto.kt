package com.github.perzotprogrammer.meetingplanner.core.repository.data


data class MeetingDto(
    val title: String,
    val description: String,
    val date: String,
    val time: String,
    val duration: Int,
    val location: String,
    val participants: List<String>
)
