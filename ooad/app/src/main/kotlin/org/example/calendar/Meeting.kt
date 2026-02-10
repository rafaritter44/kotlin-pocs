package org.example.calendar

import java.time.LocalDateTime

data class Meeting(
    val host: String,
    val title: String,
    val location: String,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val attendees: Set<String>
) {
    init {
        require(start < end)
    }
    fun overlaps(other: Meeting): Boolean =
        start < other.end && end > other.start
}
