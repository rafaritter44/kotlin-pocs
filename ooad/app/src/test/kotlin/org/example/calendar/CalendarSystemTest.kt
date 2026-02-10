package org.example.calendar

import java.time.Duration
import java.time.LocalDateTime
import java.time.Month
import kotlin.test.Test

class CalendarSystemTest {
    @Test fun calendarSystemWorks() {
        val aliceCalendar = CalendarSystem.getCalendar("Alice")
        val bobCalendar = CalendarSystem.getCalendar("Bob")

        val aliceMeeting = Meeting(
            host = "Alice",
            title = "Alice's meeting",
            location = "Room 1",
            start = LocalDateTime.of(2026, Month.FEBRUARY, 20, 15, 30),
            end = LocalDateTime.of(2026, Month.FEBRUARY, 20, 16, 30),
            attendees = setOf("Alice", "Bob", "Charlie")
        )
        val bobMeeting = Meeting(
            host = "Bob",
            title = "Bob's meeting",
            location = "Room 2",
            start = LocalDateTime.of(2026, Month.FEBRUARY, 20, 16, 45),
            end = LocalDateTime.of(2026, Month.FEBRUARY, 20, 17, 15),
            attendees = setOf("Bob", "David")
        )
        val charlieMeeting = Meeting(
            host = "Charlie",
            title = "Charlie's meeting",
            location = "Room 1",
            start = LocalDateTime.of(2026, Month.FEBRUARY, 20, 16, 30),
            end = LocalDateTime.of(2026, Month.FEBRUARY, 20, 17, 0),
            attendees = setOf("Alice", "Charlie")
        )

        println(aliceCalendar.book(aliceMeeting))
        println(aliceCalendar.book(charlieMeeting))
        println(bobCalendar.book(aliceMeeting))
        println(bobCalendar.book(bobMeeting))

        println(aliceCalendar.listMeetings())
        println(bobCalendar.listMeetings())

        fun suggestMeetingTime() =
            CalendarSystem.suggestMeetingTime(
                aliceCalendar,
                bobCalendar,
                LocalDateTime.of(2026, Month.FEBRUARY, 20, 15, 20),
                LocalDateTime.of(2026, Month.FEBRUARY, 20, 18, 0),
                Duration.ofMinutes(15)
            )
        println(suggestMeetingTime())

        println(aliceCalendar.remove(charlieMeeting))
        println(suggestMeetingTime())
    }
}