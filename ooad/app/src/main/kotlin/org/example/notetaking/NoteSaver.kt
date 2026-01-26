package org.example.notetaking

import com.google.gson.Gson
import java.io.File
import java.time.Instant
import java.util.UUID

object NoteSaver {
    private val notes = mutableMapOf<UUID, Note>()
    private val db = File("notes.db")
    private val gson = Gson()

    fun add(title: String): UUID {
        val note = Note(title = title)
        notes[note.id] = note
        return note.id
    }
    fun delete(id: UUID) {
        notes.remove(id)
    }
    fun edit(id: UUID, title: String? = null, content: String? = null): Boolean {
        if (title == null && content == null) return false
        val note = notes[id] ?: return false
        title?.let { note.title = it }
        content?.let { note.content = it }
        note.updatedAt = Instant.now()
        return true
    }
    fun viewAll(): String {
        return gson.toJson(notes)
    }
    fun save() {
        val json = gson.toJson(notes)
        db.writeText(json)
    }
    fun sync() {
        if (!db.exists()) return
        db.readLines()
            .filter { it.isNotBlank() }
            .map { gson.fromJson(it, Note::class.java) }
            .forEach { notes[it.id] = it }
    }
}