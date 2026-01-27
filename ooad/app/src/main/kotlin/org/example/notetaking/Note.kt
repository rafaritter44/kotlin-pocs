package org.example.notetaking

import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var content: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    var updatedAt: Long = System.currentTimeMillis(),
)
