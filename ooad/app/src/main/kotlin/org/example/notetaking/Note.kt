package org.example.notetaking

import java.time.Instant
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var content: String = "",
    val createdAt: Instant = Instant.now(),
    var updatedAt: Instant = Instant.now(),
)
