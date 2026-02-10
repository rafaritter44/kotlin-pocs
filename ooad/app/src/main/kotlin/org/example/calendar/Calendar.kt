package org.example.calendar

class Calendar {
    private val meetings: MutableList<Meeting> = mutableListOf()

    fun book(meeting: Meeting): Boolean {
        if (meetings.any { it.overlaps(meeting) }) {
            return false
        }
        meetings.add(meeting)
        meetings.sortBy { it.start }
        return true
    }
    fun remove(meeting: Meeting): Boolean =
        meetings.remove(meeting)
    fun listMeetings(): List<Meeting> =
        meetings.toList()
}
