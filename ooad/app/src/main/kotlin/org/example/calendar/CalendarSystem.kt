package org.example.calendar

import java.time.Duration
import java.time.LocalDateTime

class CalendarSystem {
    private val calendars = mutableMapOf<String, Calendar>()

    fun getCalendar(user: String): Calendar =
        calendars.getOrPut(user) { Calendar() }

    fun suggestMeetingTime(
        c1: Calendar,
        c2: Calendar,
        windowStart: LocalDateTime,
        windowEnd: LocalDateTime,
        duration: Duration
    ): Pair<LocalDateTime, LocalDateTime>? {
        val busySlots = (c1.listMeetings() + c2.listMeetings())
            .filter { it.start < windowEnd && it.end > windowStart }
            .sortedBy { it.start }
        var currentStart = windowStart
        for (meeting in busySlots) {
            if (currentStart.plus(duration) <= meeting.start) {
                return currentStart to currentStart.plus(duration)
            }
            if (meeting.end > currentStart) {
                currentStart = meeting.end
            }
        }
        return if (currentStart.plus(duration) <= windowEnd) {
            currentStart to currentStart.plus(duration)
        } else {
            null
        }
    }
}