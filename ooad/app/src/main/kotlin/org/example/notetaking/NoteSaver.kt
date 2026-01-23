package org.example.notetaking

import java.util.UUID

object NoteSaver {
    private val notes = mutableMapOf<UUID, Note>()

    fun add(title: String): UUID {
        val note = Note(title = title)
        notes[note.id] = note
        return note.id
    }
    fun delete(id: UUID) {
        notes.remove(id)
    }
    fun edit(id: UUID, title: String, content: String): Boolean {
        val note = notes[id] ?: return false
        note.title = title
        note.content = content
        return true
    }
}